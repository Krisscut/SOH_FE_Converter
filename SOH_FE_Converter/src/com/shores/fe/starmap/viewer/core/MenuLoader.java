package com.shores.fe.starmap.viewer.core;

import generated.Starmap;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import com.shores.fe.starmap.viewer.models.Universe;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Administrateur
 */
public class MenuLoader {
    final FileChooser fileChooser = new FileChooser();
    private MenuBar menuBar;
    private SOH_FE_Converter core;

    public MenuLoader(Stage stage,SOH_FE_Converter converter) {
        core = converter;
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
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(data));
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    final DocumentBuilder builder = factory.newDocumentBuilder();      
                    final Document document= builder.parse(is);
                }
                catch (final ParserConfigurationException e) {
                    e.printStackTrace();
                }
                catch (final SAXException e) {
                    e.printStackTrace();
                }
                catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
        MenuItem loadXML = new MenuItem("Load XML File");
        loadXML.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                
                File file = fileChooser.showOpenDialog(stage);
                
                JAXBContext jc;
                try {
                    jc = JAXBContext.newInstance(Starmap.class);


                    Unmarshaller unmarshaller = jc.createUnmarshaller();
                    Starmap starmap = (Starmap) unmarshaller.unmarshal(file);
/*
                    Marshaller marshaller = jc.createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    marshaller.marshal(starmap, System.out);
                    */
                } catch (Exception ex) {
                    Logger.getLogger(MenuLoader.class.getName()).log(Level.SEVERE, null, ex);
                }
                /**
                try {
                    
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder(); 
                    Document document= builder.parse(file);
                    Universe universe = new Universe(document);
                    
                    core.tableTreeExplorer.setNewTableContent(universe);
                }
                catch (final ParserConfigurationException e) {
                    e.printStackTrace();
                }
                catch (final SAXException e) {
                    e.printStackTrace();
                }
                catch (final IOException e) {
                    e.printStackTrace();
                }
                * */
            }
        });
        menuEdit.getItems().addAll(paste,loadXML);
        
        // --- Menu View
        Menu menuView = new Menu("View");
        
        Menu menuHelp = new Menu("?");
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
    }

    MenuBar getMenuBar() {
        return menuBar;
    }
    
    
    
}
