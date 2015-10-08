package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.MenuController;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.observability.Observer;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
    
    public MenuView(Stage stage, MenuController menuController) {
        /**
         * DEBUG
         */
        fileChooser.setInitialDirectory(new File("D:\\Projects\\tests\\JAVAFX\\JAVAFX"));
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
                //vbox.setVisible(false);
            }
        });
        
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
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
                String data = Clipboard.getSystemClipboard().getContent(DataFormat.PLAIN_TEXT).toString(); 
                
            }
        });
        
        MenuItem loadXML = new MenuItem("Load XML File");
        loadXML.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                
                File file = fileChooser.showOpenDialog(stage );
                menuController.loadXMLFromFile(file);
                
            }
        });
        menuEdit.getItems().addAll(paste,loadXML);
        
        // --- Menu View
        Menu menuView = new Menu("View");
        
        Menu menuHelp = new Menu("?");
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
    }
    
    @Override
    public Node getViewElement() {
        return menuBar;
    }

    @Override
    public void update(FeedbackCode code) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
