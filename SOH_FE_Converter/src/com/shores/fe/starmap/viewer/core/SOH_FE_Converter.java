package com.shores.fe.starmap.viewer.core;

import com.shores.fe.starmap.viewer.controllers.BBCodeExporterController;
import com.shores.fe.starmap.viewer.controllers.MenuController;
import com.shores.fe.starmap.viewer.controllers.SearchModuleController;
import com.shores.fe.starmap.viewer.controllers.TableTreeExplorerController;
import com.shores.fe.starmap.viewer.core.Configuration.Configuration;
import com.shores.fe.starmap.viewer.models.ConverterData;
import com.shores.fe.starmap.viewer.views.BBCodeExporterView;
import com.shores.fe.starmap.viewer.views.MenuView;
import com.shores.fe.starmap.viewer.views.SearchModuleView;
import com.shores.fe.starmap.viewer.views.StatusBarView;
import com.shores.fe.starmap.viewer.views.TableTreeExplorerView;
import com.shores.fe.starmap.viewer.views.ToolbarView;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.ExceptionDialog;
import org.controlsfx.glyphfont.FontAwesome;

//TODO : singleton pattern
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
    
    FontAwesome fontAwesome = new FontAwesome();
    
    @Override
    public void start(Stage stage) {
        //Thread.setDefaultUncaughtExceptionHandler(SOH_FE_Converter::showError);
        Thread.currentThread().setName("SOH_FE_CONVERTER_MAIN");
        

        depimg = new Image(getClass().getClassLoader().getResourceAsStream("com/shores/fe/starmap/viewer/resources/icons/planet.png"));
        depIcon = new ImageView (depimg);
        depIcon.setFitWidth(16);
        depIcon.setPreserveRatio(true);
        depIcon.setSmooth(true);
        depIcon.setCache(true);
        
        
        mainVBox = new VBox();
        mainVBox.setAlignment(Pos.TOP_CENTER);

        vbox = new VBox();

        //Create global model 
        ConverterData model = new ConverterData();

        menuController = MenuController.getInstance();
        menuController.init(model, this);
        menuView = new MenuView(stage, menuController);
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
        
        StatusBarView statusBar = StatusBarView.getInstance();
        ToolbarView toolbarView = ToolbarView.getInstance();
        
        mainVBox.getChildren().addAll(menuView.getViewElement(), toolbarView.getViewElement(),vbox, statusBar.getViewElement());

        /** Notification pane test */
        
        NotificationPane notificationPane = new NotificationPane();
        
        ImageView notifIcon = new ImageView (depimg);
        notifIcon.setFitWidth(40);
        notifIcon.setPreserveRatio(true);
        notifIcon.setSmooth(true);
        notifIcon.setCache(true);
        
        notificationPane.setGraphic(notifIcon);
        notificationPane.setShowFromTop(false);
        notificationPane.getStyleClass().add(NotificationPane.STYLE_CLASS_DARK);
        notificationPane.setText("This is a work in progress software, please give feedback using the github issues system !");
        
        notificationPane.getActions().addAll(new Action("Feedback", ae -> {
            try {
                Desktop.getDesktop().browse(new URI(Configuration.GITHUB_ISSUES_URL));
            } catch (Exception ex) {
                Logger.getLogger(SOH_FE_Converter.class.getName()).log(Level.SEVERE, null, ex);
            }
            notificationPane.hide();
        }));
        notificationPane.setContent(mainVBox);

        Scene scene = new Scene(notificationPane, 1250, 700);
        
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
        stage.show();
        stage.setMinHeight(Configuration.MAIN_WINDOW_HEIGHT);
        stage.setMinWidth(Configuration.MAIN_WINDOW_WIDTH);
        
        notificationPane.show();
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
