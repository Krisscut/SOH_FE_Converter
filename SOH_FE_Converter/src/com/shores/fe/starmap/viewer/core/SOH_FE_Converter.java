package com.shores.fe.starmap.viewer.core;

import generated.City;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SOH_FE_Converter extends Application {
    //UI Components
    public MenuLoader menuLoader;
    public SearchModule searchModule;
    public BBCodeExporter bbCodeExporter;
    public TableTreeExplorer tableTreeExplorer;
    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox();
        
        Scene scene = new Scene(vbox, 800, 600);
        menuLoader= new MenuLoader(stage, this);
        vbox.getChildren().addAll(menuLoader.getMenuBar());
        
        searchModule = new SearchModule();
        vbox.getChildren().addAll(searchModule.getSearchBar());
        
        tableTreeExplorer = new TableTreeExplorer();
        vbox.getChildren().add(tableTreeExplorer.getTableTreeComponent());
        
        bbCodeExporter = new BBCodeExporter();
        vbox.getChildren().addAll(bbCodeExporter.getBBCodeComponent());

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
