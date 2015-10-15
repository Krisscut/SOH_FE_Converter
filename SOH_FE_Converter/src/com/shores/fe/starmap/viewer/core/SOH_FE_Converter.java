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
import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.AbstractAction;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.dialog.ExceptionDialog;

public class SOH_FE_Converter extends Application {
    public Image depimg;
    public ImageView depIcon;
    
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
    
    VBox vbox , mainVBox = null;
    SplitPane split = null;
    
    @Override
    public void start(Stage stage) {
        Thread.setDefaultUncaughtExceptionHandler(SOH_FE_Converter::showError);
        Thread.currentThread().setName("SOH_FE_CONVERTER_MAIN");
        mainVBox = new VBox();
        mainVBox.setAlignment(Pos.TOP_CENTER);
        
        depimg = new Image(getClass().getClassLoader().getResourceAsStream("com/shores/fe/starmap/viewer/resources/icons/planet.png"));
        depIcon = new ImageView (depimg);
        depIcon.setFitWidth(16);
        depIcon.setPreserveRatio(true);
        depIcon.setSmooth(true);
        depIcon.setCache(true);

        vbox = new VBox();

        //Create global model 
        ConverterData model = new ConverterData();

        menuController = MenuController.getInstance();
        menuController.init(model, this);
        menuView = new MenuView(stage, menuController);

        Label label = new Label("This is a WORK IN PROGRESS software");
        label.setPrefWidth(5000);
        label.setStyle(""
                + " -fx-font: 50px Tahoma;"
                + " -fx-text-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);"
                + " -fx-stroke: black;"
                + " -fx-background-color: #A7BDDB;"
                + " -fx-stroke-width: 1;");
        label.setAlignment(Pos.CENTER);

        searchModuleController = SearchModuleController.getInstance();
        searchModuleController.init(model, this);
        searchModuleView = new SearchModuleView(searchModuleController);
        vbox.getChildren().add(searchModuleView.getViewElement());

        //Split pane to hold the main view
        split = new SplitPane();
        split.setOrientation(Orientation.VERTICAL);
        split.setDividerPositions(0.8f);

        tableTreeExplorerController = TableTreeExplorerController.getInstance();
        tableTreeExplorerController.init(model, this);
        tableTreeExplorerView = new TableTreeExplorerView(tableTreeExplorerController);
        //vbox.getChildren().add(tableTreeExplorerView.getViewElement());

        bbCodeExporterController = BBCodeExporterController.getInstance();
        bbCodeExporterController.init(model, this);
        bbCodeExporterView = new BBCodeExporterView(bbCodeExporterController);

        split.getItems().addAll(tableTreeExplorerView.getViewElement(),bbCodeExporterView.getViewElement());
        //vbox.getChildren().add(bbCodeExporterView.getViewElement());
        vbox.getChildren().add(split);

        model.addObserver(menuView);
        model.addObserver(searchModuleView);
        model.addObserver(tableTreeExplorerView);
        model.addObserver(bbCodeExporterView);

        /**
        TabPane tabPane = new TabPane();
        Tab tab = new Tab();
        tab.setText("Database Converter");
        tab.setContent(vbox);
        tabPane.getTabs().add(tab);
        * */
        mainVBox.getChildren().addAll(menuView.getViewElement(), label, vbox);

        /*
        // Wrap it inside a NotificationPane
        NotificationPane notificationPane = new NotificationPane(mainVBox);
        notificationPane.getStyleClass().add(NotificationPane.STYLE_CLASS_DARK);

        notificationPane.setText("Do you want to save your password?");
        notificationPane.setShowFromTop(false);
        notificationPane.show();
        */

        
        Scene scene = new Scene(mainVBox, 1200, 700);

        //Global CSS
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        /** Drag and drop part*/
        scene.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                } else {
                    event.consume();
                }
            }
        });
        scene.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    success = true;
                    String filePath = null;
                    for (File file:db.getFiles()) {
                        filePath = file.getAbsolutePath();
                        System.out.println(filePath);
                        //TODO : handle drag and drop
                    }
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
        
        

        stage.setTitle("SOH FE Converter");
        stage.setScene(scene);
        stage.show();
    }
    
    private static void showError(Thread t, Throwable e) {
        System.err.println("***Default exception handler***");
        if (Platform.isFxApplicationThread()) {
            new ExceptionDialog(e).showAndWait();
            //DialogUtils.showExceptionDialog(e);
        } else {
            System.err.println("An unexpected error occurred in "+t);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public BBCodeExporterController getBbCodeExporterController() {
        return bbCodeExporterController;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public SearchModuleController getSearchModuleController() {
        return searchModuleController;
    }

    public TableTreeExplorerController getTableTreeExplorerController() {
        return tableTreeExplorerController;
    }

    public BBCodeExporterView getBbCodeExporterView() {
        return bbCodeExporterView;
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public SearchModuleView getSearchModuleView() {
        return searchModuleView;
    }

    public TableTreeExplorerView getTableTreeExplorerView() {
        return tableTreeExplorerView;
    }

    public VBox getVbox() {
        return vbox;
    }

    public VBox getMainVBox() {
        return mainVBox;
    }

    public SplitPane getSplit() {
        return split;
    }
    
    
}
