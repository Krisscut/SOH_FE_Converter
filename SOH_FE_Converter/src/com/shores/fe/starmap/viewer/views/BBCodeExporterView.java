package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.BBCodeExporterController;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.interfaces.observability.Observer;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.Metrics;
import com.shores.fe.starmap.viewer.models.ui.ButtonUtils;
import com.shores.fe.starmap.viewer.utils.DialogUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BBCodeExporterView implements IView, Observer{
    BBCodeExporterController controller;
    private VBox bbCodeContainer;
    private GridPane bbCodeGrid;
    
    Button exportSelection, exportToClipboard;
    TextArea bbcodePreview = null;
    
    public BBCodeExporterView(BBCodeExporterController bbCodeExporterController) {
        this.controller = bbCodeExporterController;
        
        bbCodeContainer = new VBox();
        
        bbCodeGrid = new GridPane();
        
        exportSelection = ButtonUtils.generateButton("Export Selection");
        GridPane.setConstraints(exportSelection, 0, 0);
        bbCodeGrid.getChildren().add(exportSelection);
        
        exportToClipboard = ButtonUtils.generateButton("Copy content to clipboard");
        GridPane.setConstraints(exportToClipboard, 1, 0);
        bbCodeGrid.getChildren().add(exportToClipboard);
        
        bbCodeGrid.setAlignment(Pos.CENTER);
        
        bbcodePreview = new TextArea();
        bbcodePreview.setPrefRowCount(10);
        bbcodePreview.setPrefColumnCount(100);
        bbcodePreview.setWrapText(true);
        GridPane.setHalignment(bbcodePreview, HPos.CENTER);
        String bbCodeDefault = "Generated bbcode will appear here.";
        bbcodePreview.setText(bbCodeDefault);
        bbcodePreview.setPrefHeight(2000);

        
        bbCodeContainer.getChildren().addAll(bbCodeGrid, bbcodePreview);       //add /remove the preview if necessary

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
            }
        });
        
        bbCodeContainer.setStyle("-fx-background-color: #336699;");
        
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
        if (controller.getModel().isShowViewExporter()) {
            this.controller.getCore().getSplit().getItems().add(this.bbCodeContainer);
        }
        else {
            this.controller.getCore().getSplit().getItems().remove(this.bbCodeContainer);
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
    
}
