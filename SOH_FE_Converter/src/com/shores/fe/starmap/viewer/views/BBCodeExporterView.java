package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.BBCodeExporterController;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.observability.Observer;
import com.shores.fe.starmap.viewer.models.ui.ButtonUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BBCodeExporterView implements IView, Observer{
    BBCodeExporterController controller;
    private VBox bbCodeContainer;
    private GridPane bbCodeGrid;
    
    Button exportAll = null;
    Button exportSelection = null;
    Button exportFiltered = null;
    TextArea bbcodePreview = null;
    
    public BBCodeExporterView(BBCodeExporterController bbCodeExporterController) {
        this.controller = bbCodeExporterController;
        
        bbCodeContainer = new VBox();
        
        bbCodeGrid = new GridPane();
        exportAll = ButtonUtils.generateButton("Export all");
        GridPane.setConstraints(exportAll, 0, 0);
        bbCodeGrid.getChildren().add(exportAll);
        
        exportSelection = ButtonUtils.generateButton("Export Selection");
        GridPane.setConstraints(exportSelection, 1, 0);
        bbCodeGrid.getChildren().add(exportSelection);
       
        exportFiltered = ButtonUtils.generateButton("Export Filtered");
        GridPane.setConstraints(exportFiltered, 2, 0);

        bbCodeGrid.getChildren().add(exportFiltered);
        bbCodeGrid.setAlignment(Pos.CENTER);
        
        bbcodePreview = new TextArea();
        bbcodePreview.setPrefRowCount(10);
        bbcodePreview.setPrefColumnCount(100);
        bbcodePreview.setWrapText(true);
        GridPane.setHalignment(bbcodePreview, HPos.CENTER);
        String bbCodeDefault = "Generated bbcode will appear here.";
        bbcodePreview.setText(bbCodeDefault);
        bbcodePreview.setPrefHeight(2000);
        
        bbCodeContainer.getChildren().addAll(bbCodeGrid, bbcodePreview);

        //Events handler
        exportAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                controller.handleExportAll();
            }
        });
        
        exportSelection.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                controller.handleExportSelection();
            }
        });
        
        exportFiltered.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                controller.handleFilteredExport();
            }
        });
        
        bbCodeContainer.setStyle("-fx-background-color: #336699;");
        
    }

    @Override
    public Node getViewElement() {
        return bbCodeContainer;
    }
    
    private void setBBCodePreview(){
        bbcodePreview.setText(controller.getModel().getGeneratedBBCode());
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
