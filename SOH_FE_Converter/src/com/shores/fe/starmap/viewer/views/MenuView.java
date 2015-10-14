package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.MenuController;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.observability.Observer;
import com.shores.fe.starmap.viewer.utils.DialogUtils;
import java.io.File;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MenuView implements IView, Observer{
    final FileChooser fileChooser = new FileChooser();
    private MenuBar menuBar;
    private MenuController menuController;
    
    Menu menuView;
    CheckMenuItem displaySearch, displayTableTree, displayExporter;
    
    private File lastDataLocation = new File("D:\\Dev\\Projects\\tests\\JAVAFX\\JAVAFX");
            
    public MenuView(Stage stage, MenuController menuController) {
        /**
         * DEBUG
         */
        fileChooser.getExtensionFilters().clear();
        ExtensionFilter filter = new ExtensionFilter("XML Files", "*.xml");
        fileChooser.getExtensionFilters().add(filter);
        fileChooser.setSelectedExtensionFilter(filter);
        fileChooser.setTitle("Please select a valid starmap XML file");
        
        
        this.menuController = menuController;
        
        menuBar = new MenuBar();
        // --- Menu File
        Menu menuFile = new Menu("File");
        
        MenuItem clear = new MenuItem("Clear");
        clear.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                DialogUtils.notImplementedYetDialog();
            }
        });
        
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Exit application ?");
                alert.setContentText("Are you sure you want to close the application?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    System.exit(0);
                } else {
                    // ... user chose CANCEL or closed the dialog
                }

            }
        });
        menuFile.getItems().addAll(clear, new SeparatorMenuItem(), exit);
        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
        
        //Paste from clipboard into the application
        MenuItem paste = new MenuItem("Paste Clipboard");
        paste.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                DialogUtils.notImplementedYetDialog();
                //String data = Clipboard.getSystemClipboard().getContent(DataFormat.PLAIN_TEXT).toString(); 
            }
        });
        
        MenuItem loadXML = new MenuItem("Load XML File");
        loadXML.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                if (lastDataLocation.exists()) {
                    fileChooser.setInitialDirectory(lastDataLocation);
                }
                File file = fileChooser.showOpenDialog(stage );
                if (file != null && file.exists()){
                    lastDataLocation = file.getParentFile();
                    menuController.loadXMLFromFile(file);
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Error !");
                    alert.setContentText("There is an error with the given file, maybe it's missing or not selected.");
                    alert.showAndWait();
                }
            }
        });
        menuEdit.getItems().addAll(paste,loadXML);
        
        // --- Menu View
        menuView = new Menu("View");
        
        displaySearch = new CheckMenuItem("Show Search Fields");
        displaySearch.setSelected(true);
        displaySearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                menuController.handleShowSearchFieldsAction(displaySearch.isSelected());
                
            }
        });
        
        displayTableTree = new CheckMenuItem("Show data table");
        displayTableTree.setSelected(true);
        displayTableTree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                menuController.handleShowTableTreeAction(displayTableTree.isSelected());
                
            }
        });
        
        displayExporter = new CheckMenuItem("Show Exporter");
        displayExporter.setSelected(true);
        displayExporter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                menuController.handleShowExporterAction(displayExporter.isSelected());
                
            }
        });
        
        menuView.getItems().addAll(displaySearch,displayTableTree, displayExporter);
        
        Menu menuHelp = new Menu("?");
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
    }
    
    @Override
    public Node getViewElement() {
        return menuBar;
    }
    
    private void updateViewMenuItems(){
        displayExporter.setSelected(menuController.getModel().isShowViewExporter());
        displaySearch.setSelected(menuController.getModel().isShowViewSearch());
        displayTableTree.setSelected(menuController.getModel().isShowViewTableTree());
    }

    @Override
    public void update(FeedbackCode code) {
        switch(code) {
            case EXPORTER_VIEW_CHANGED:
            case GLOBAL_VIEW_CHANGED:
            case SEARCH_VIEW_CHANGED:
            case TREETABLE_VIEW_CHANGED:
                updateViewMenuItems();
        } 
    }

    public CheckMenuItem getDisplaySearch() {
        return displaySearch;
    }

    public CheckMenuItem getDisplayTableTree() {
        return displayTableTree;
    }

    public CheckMenuItem getDisplayExporter() {
        return displayExporter;
    }
    
    
}
