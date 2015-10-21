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
    //controller
    private MenuController controller;
    
    //UI Components
    MenuBar menuBar;
    Menu menuFile, menuEdit, menuView, menuHelp;
    MenuItem clear, exit, paste, loadXML, websiteItem, trelloItem, repositoryItem, bugTrackerItem, aboutItem;
    CheckMenuItem displaySearch, displayTableTree, displayExporter;
    
    //Others vars
    final FileChooser fileChooser = new FileChooser();
    private File lastDataLocation = new File("D:\\Dev\\Projects\\tests\\JAVAFX\\JAVAFX");
    FontAwesome fontAwesome = new FontAwesome();
    Stage stage;
            
    public MenuView(Stage stage, MenuController menuController) {
        this.controller = menuController;
        this.stage = stage;
        
        fileChooser.getExtensionFilters().clear();
        ExtensionFilter filter = new ExtensionFilter("XML Files", "*.xml");
        fileChooser.getExtensionFilters().add(filter);
        fileChooser.setSelectedExtensionFilter(filter);
        fileChooser.setTitle("Please select a valid starmap XML file");
        
        initUIComponents();
        setUpComponentsLocation();
        addEventHandler();
    }
    
    @Override
    public Node getViewElement() {
        return menuBar;
    }

    @Override
    public void initUIComponents() {
        menuBar = new MenuBar();
        
        // --- Menu File
        menuFile = new Menu("File");
        
        clear = new MenuItem("Clear");
        clear.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        
        exit = new MenuItem("Exit");

        // --- Menu Edit
        menuEdit = new Menu("Edit");
        
        //Paste from clipboard into the application
        paste = new MenuItem("Paste Clipboard");
        
        loadXML = new MenuItem("Load XML File");
        loadXML.setGraphic(fontAwesome.create(FontAwesome.Glyph.FILE).size(16).color(Color.DARKCYAN));

        // --- Menu View
        menuView = new Menu("View");
        
        displaySearch = new CheckMenuItem("Show Search Fields");
        displaySearch.setSelected(true);
        
        displayTableTree = new CheckMenuItem("Show data table");
        displayTableTree.setSelected(true);
        
        displayExporter = new CheckMenuItem("Show Exporter");
        displayExporter.setSelected(true);
        
        menuView.getItems().addAll(displaySearch,displayTableTree, displayExporter);
        
        menuHelp = new Menu("?");
        
        websiteItem = new MenuItem("Website");

        trelloItem = new MenuItem("Trello board");
        
        repositoryItem = new MenuItem("Github repository");
        
        bugTrackerItem = new MenuItem("Bug tracker");
        
        //TODO : about dialog
        aboutItem = new MenuItem("About");
        
        menuHelp.getItems().addAll(websiteItem,trelloItem, repositoryItem, bugTrackerItem, aboutItem);

        menuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuHelp);
    }

    @Override
    public void setUpComponentsLocation() {
        menuFile.getItems().addAll(clear, new SeparatorMenuItem(), exit);
        menuEdit.getItems().addAll(paste, loadXML);
    }

    @Override
    public void addEventHandler() {
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                DialogUtils.notImplementedYetDialog();
            }
        });
        
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
        
        paste.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                DialogUtils.notImplementedYetDialog();
                //String data = Clipboard.getSystemClipboard().getContent(DataFormat.PLAIN_TEXT).toString(); 
            }
        });
        
        loadXML.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                if (lastDataLocation.exists()) {
                    fileChooser.setInitialDirectory(lastDataLocation);
                }
                File file = fileChooser.showOpenDialog(stage );
                if (file != null && file.exists()){
                    lastDataLocation = file.getParentFile();
                    controller.loadXMLFromFile(file);
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Error !");
                    alert.setContentText("There is an error with the given file, maybe it's missing or not selected.");
                    alert.showAndWait();
                }
            }
        });
        
        displaySearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                controller.handleShowSearchFieldsAction(displaySearch.isSelected());
            }
        });
        
        displayTableTree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                controller.handleShowTableTreeAction(displayTableTree.isSelected());
                
            }
        });
        
        displayExporter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                controller.handleShowExporterAction(displayExporter.isSelected());
                
            }
        });
        
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
        
        aboutItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Notifications.create()
                    .title("Not implemented Yet")
                    .text("Sorry, this functionnality has not been implemented yet")
                    .showWarning();
            }
        });
        
        //Bind the boolean from the model to the button state
        controller.getModel().isShowViewExporter().bindBidirectional(displayExporter.selectedProperty());
        controller.getModel().isShowViewSearch().bindBidirectional(displaySearch.selectedProperty());
        controller.getModel().isShowViewTableTree().bindBidirectional(displayTableTree.selectedProperty());
    }

    @Override
    public void update(FeedbackCode code) {
        switch(code) {
            case EXPORTER_VIEW_CHANGED:
            case GLOBAL_VIEW_CHANGED:
            case SEARCH_VIEW_CHANGED:
            case TREETABLE_VIEW_CHANGED:
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
