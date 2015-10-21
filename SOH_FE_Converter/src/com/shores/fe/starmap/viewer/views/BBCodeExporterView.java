package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.BBCodeExporterController;
import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.interfaces.observability.Observer;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.Metrics;
import com.shores.fe.starmap.viewer.utils.DialogUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import org.controlsfx.glyphfont.FontAwesome;

public class BBCodeExporterView implements IView, Observer{
    //Controller
    BBCodeExporterController controller;
    
    //UI Componenets
    HBox bbCodeContainer;
    ToolBar toolBar;
    Button exportSelection, exportToClipboard;
    TextArea bbcodePreview;
    
    //Other
    FontAwesome fontAwesome = new FontAwesome();
    
    public BBCodeExporterView(BBCodeExporterController bbCodeExporterController) {
        this.controller = bbCodeExporterController;
        
        initUIComponents();
        setUpComponentsLocation();
        addEventHandler();
    }

    @Override
    public Node getViewElement() {
        return bbCodeContainer;
    }
    
    private void setBBCodePreview(){
        /*
        if (controller.getModel().getGeneratedBBCode().isEmpty()) {
            if (bbCodeContainer.getChildren().contains(bbcodePreview)){
                bbCodeContainer.getChildren().remove(bbcodePreview);
            }
            controller.getCore();
        } else {
            bbCodeContainer.getChildren().add(bbcodePreview);
            bbcodePreview.setText(controller.getModel().getGeneratedBBCode());
        }
        */
        if (!controller.getModel().getGeneratedBBCode().isEmpty()){
            bbcodePreview.setText(controller.getModel().getGeneratedBBCode());
            DialogUtils.showInformationNotification("BBCode export", "BBCode generated, contains " + Metrics.GetExportCounter() + " entries !");
        }
    }
    
    private void updateVisibility() {
        if (controller.getModel().isShowViewExporter().get()) {
            SOH_FE_Converter.coreView.getSplit().getItems().add(this.bbCodeContainer);
        }
        else {
            SOH_FE_Converter.coreView.getSplit().getItems().remove(this.bbCodeContainer);
        }
    }

    @Override
    public void update(FeedbackCode code) {
        switch(code) {
            case REFRESH_ALL:
            case MAIN_DATA_CHANGED:
            case BBCODE_GENERATED:
                setBBCodePreview();
                break;
            case EXPORTER_VIEW_CHANGED:
                updateVisibility();
                break;
        } 
    }

    @Override
    public void initUIComponents() {
        bbCodeContainer = new HBox();
        bbCodeContainer.setStyle("-fx-background-color: #336699;");
        
        exportSelection = new Button("Export", fontAwesome.create(FontAwesome.Glyph.CHECK).size(16).color(Color.DARKBLUE));
        exportSelection.setPrefWidth(80);
        exportToClipboard = new Button("Copy", fontAwesome.create(FontAwesome.Glyph.COPY).size(16).color(Color.DARKBLUE));
        exportToClipboard.setPrefWidth(80);
                
        toolBar = new ToolBar();
        toolBar.setOrientation(Orientation.VERTICAL);
        
        bbcodePreview = new TextArea();
        bbcodePreview.setPrefHeight(Integer.MAX_VALUE);
        bbcodePreview.setPrefWidth(Integer.MAX_VALUE);
        bbcodePreview.setPrefRowCount(10);
        bbcodePreview.setPrefColumnCount(100);
        bbcodePreview.setWrapText(true);
        String bbCodeDefault = "Generated bbcode will appear here.";
        bbcodePreview.setText(bbCodeDefault);
    }

    @Override
    public void setUpComponentsLocation() {
        toolBar.getItems().addAll(exportSelection, exportToClipboard);
        
        GridPane.setHalignment(bbcodePreview, HPos.CENTER);
        
        bbCodeContainer.getChildren().addAll(toolBar, bbcodePreview);
    }

    @Override
    public void addEventHandler() {
        //Events handler
        exportSelection.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                controller.handleExportSelection();
            }
        });
        
        exportToClipboard.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Action handle on the view to prevent javafx components inport into the controller.
                final Clipboard clipboard = Clipboard.getSystemClipboard();
                final ClipboardContent content = new ClipboardContent();
                content.putString(controller.getModel().getGeneratedBBCode());
                clipboard.setContent(content);
                DialogUtils.showInformationNotification("Content exported to your clipboard !", "The bbCode generated is now ready to paste from you clipboard");
            }
        });
    }
    
}
