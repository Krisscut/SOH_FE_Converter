package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.MenuController;
import com.shores.fe.starmap.viewer.core.Configuration.Configuration;
import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.interfaces.observability.Observer;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.utils.DialogUtils;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import org.controlsfx.glyphfont.FontAwesome;

public class MenuView implements IView, Observer{
    final FileChooser fileChooser = new FileChooser();
    private MenuBar menuBar;
    private MenuController menuController;
    
    Menu menuView;
    CheckMenuItem displaySearch, displayTableTree, displayExporter;
    
    private File lastDataLocation = new File("D:\\Dev\\Projects\\tests\\JAVAFX\\JAVAFX");
    
    FontAwesome fontAwesome = new FontAwesome();
            
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
        loadXML.setGraphic(fontAwesome.create(FontAwesome.Glyph.FILE).size(16).color(Color.DARKCYAN));
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
        
        MenuItem websiteItem = new MenuItem("Website");
        websiteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                Desktop.getDesktop().browse(new URI(Configuration.MAIN_WEBSITE));
            } catch (Exception ex) {
                Logger.getLogger(SOH_FE_Converter.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
        MenuItem trelloItem = new MenuItem("Trello board");
        trelloItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                Desktop.getDesktop().browse(new URI(Configuration.TRELLO_BOARD));
            } catch (Exception ex) {
                Logger.getLogger(SOH_FE_Converter.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
        MenuItem repositoryItem = new MenuItem("Github repository");
        repositoryItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                Desktop.getDesktop().browse(new URI(Configuration.GITHUB_MAIN_URL));
            } catch (Exception ex) {
                Logger.getLogger(SOH_FE_Converter.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
        MenuItem bugTrackerItem = new MenuItem("Bug tracker");
        bugTrackerItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                Desktop.getDesktop().browse(new URI(Configuration.GITHUB_ISSUES_URL));
            } catch (Exception ex) {
                Logger.getLogger(SOH_FE_Converter.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
        //TODO : about dialog
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Notifications.create()
                    .title("Not implemented Yet")
                    .text("Sorry, this functionnality has not been implemented yet")
                    .showWarning();
            }
        });
        
        menuHelp.getItems().addAll(websiteItem,trelloItem, repositoryItem, bugTrackerItem, aboutItem);

        menuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuHelp);
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

    @Override
    public void initUIComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUpComponentsLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEventHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
