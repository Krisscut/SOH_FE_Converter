package com.shores.fe.starmap.viewer.core;

import com.shores.fe.starmap.viewer.controllers.BBCodeExporterController;
import com.shores.fe.starmap.viewer.controllers.MenuController;
import com.shores.fe.starmap.viewer.controllers.SearchModuleController;
import com.shores.fe.starmap.viewer.controllers.TableTreeExplorerController;
import com.shores.fe.starmap.viewer.models.ConverterData;
import com.shores.fe.starmap.viewer.views.BBCodeExporterView;
import com.shores.fe.starmap.viewer.views.MenuView;
import com.shores.fe.starmap.viewer.views.SearchModuleView;
import com.shores.fe.starmap.viewer.views.TableTreeExplorerView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SOH_FE_Converter extends Application {
    //Controller
    private BBCodeExporterController bbCodeExporterController = null;
    private MenuController menuController = null;
    private SearchModuleController searchModuleController = null;
    private TableTreeExplorerController tableTreeExplorerController = null;
    
    //Views 
    private BBCodeExporterView bbCodeExporterView = null;
    private MenuView menuView = null;
    private SearchModuleView searchModuleView = null;
    private TableTreeExplorerView tableTreeExplorerView = null;
    
    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox();
        //New frame for the application
        Scene scene = new Scene(vbox, 1200, 700);
        
        //Create global model 
        ConverterData model = new ConverterData();

        menuController = MenuController.getInstance();
        menuController.init(model);
        menuView = new MenuView(stage, menuController);
        vbox.getChildren().add(menuView.getViewElement());
        
        TextField field = new TextField("THIS IS A WORK IN PROGRESS SOFTWARE");
        field.setDisable(true);
        field.setStyle("-fx-font: 22 arial; -fx-text-fill: rgb(49, 0, 23); -fx-base: #b6e7c9;");
        vbox.getChildren().add(field);
        
        searchModuleController = SearchModuleController.getInstance();
        searchModuleController.init(model);
        searchModuleView = new SearchModuleView(searchModuleController);
        vbox.getChildren().add(searchModuleView.getViewElement());
        
        tableTreeExplorerController = TableTreeExplorerController.getInstance();
        tableTreeExplorerController.init(model);
        tableTreeExplorerView = new TableTreeExplorerView(tableTreeExplorerController);
        vbox.getChildren().add(tableTreeExplorerView.getViewElement());
        
        bbCodeExporterController = BBCodeExporterController.getInstance();
        bbCodeExporterController.init(model);
        bbCodeExporterView = new BBCodeExporterView(bbCodeExporterController);

        vbox.getChildren().add(bbCodeExporterView.getViewElement());
        
        model.addObserver(menuView);
        model.addObserver(searchModuleView);
        model.addObserver(tableTreeExplorerView);
        model.addObserver(bbCodeExporterView);

        stage.setTitle("SOH FE Converter");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
