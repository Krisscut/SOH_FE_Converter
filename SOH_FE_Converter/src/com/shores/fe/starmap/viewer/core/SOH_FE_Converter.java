package com.shores.fe.starmap.viewer.core;

import com.shores.fe.starmap.viewer.controllers.BBCodeExporterController;
import com.shores.fe.starmap.viewer.controllers.MenuController;
import com.shores.fe.starmap.viewer.controllers.SearchModuleController;
import com.shores.fe.starmap.viewer.controllers.TableTreeExplorerController;
import com.shores.fe.starmap.viewer.core.Configuration.Configuration;
import com.shores.fe.starmap.viewer.models.ConverterData;
import com.shores.fe.starmap.viewer.utils.LocaleManager;
import com.shores.fe.starmap.viewer.views.BBCodeExporterView;
import com.shores.fe.starmap.viewer.views.CoreView;
import com.shores.fe.starmap.viewer.views.MenuView;
import com.shores.fe.starmap.viewer.views.SearchModuleView;
import com.shores.fe.starmap.viewer.views.TableTreeExplorerView;
import java.io.File;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import org.controlsfx.dialog.ExceptionDialog;
import org.controlsfx.glyphfont.FontAwesome;

//TODO : singleton pattern
public class SOH_FE_Converter extends Application {
    public static Image depimg;
    public static ImageView depIcon;
    public static CoreView coreView;
    
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
    

    FontAwesome fontAwesome = new FontAwesome();
    
    //Localization
    ResourceBundle bundle = LocaleManager.getStaticBundle(Configuration.DEFAULT_LOCALIZATION_LOCATION + getClass().getName());
    
    @Override
    public void start(Stage stage) {
        //Thread.setDefaultUncaughtExceptionHandler(SOH_FE_Converter::showError);
        Thread.currentThread().setName("SOH_FE_CONVERTER_MAIN");
        System.out.println(bundle.getString("test"));       //Test localization
        
        depimg = new Image(getClass().getClassLoader().getResourceAsStream("icons/planet.png"));
        depIcon = new ImageView (depimg);
        depIcon.setFitWidth(16);
        depIcon.setPreserveRatio(true);
        depIcon.setSmooth(true);
        depIcon.setCache(true);
        
        //Create global model 
        ConverterData model = new ConverterData();

        menuController = MenuController.getInstance();
        menuController.init(model, this);
        menuView = new MenuView(stage, menuController);
        searchModuleController = SearchModuleController.getInstance();
        searchModuleController.init(model, this);
        searchModuleView = new SearchModuleView(searchModuleController);

        tableTreeExplorerController = TableTreeExplorerController.getInstance();
        tableTreeExplorerController.init(model, this);
        tableTreeExplorerView = new TableTreeExplorerView(tableTreeExplorerController);

        bbCodeExporterController = BBCodeExporterController.getInstance();
        bbCodeExporterController.init(model, this);
        bbCodeExporterView = new BBCodeExporterView(bbCodeExporterController);

        model.addObserver(menuView);
        model.addObserver(searchModuleView);
        model.addObserver(tableTreeExplorerView);
        model.addObserver(bbCodeExporterView);
        
        coreView = new CoreView(menuView,searchModuleView, tableTreeExplorerView, bbCodeExporterView);
        coreView.getViewElement();
        Scene scene = new Scene((Parent) coreView.getViewElement(), 1250, 700);
        
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
        

        //Global CSS
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        stage.setTitle("SOH FE Converter");
        stage.setScene(scene);

        stage.setMinHeight(Configuration.MAIN_WINDOW_HEIGHT);
        stage.setMinWidth(Configuration.MAIN_WINDOW_WIDTH);
        
        //stage.initStyle(StageStyle.UNDECORATED);
        
        stage.show();
        coreView.getNotificationPane().show();

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
}
