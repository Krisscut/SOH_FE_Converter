package com.shores.fe.starmap.viewer.controllers;

import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.IController;
import com.shores.fe.starmap.viewer.models.AbstractModel;
import com.shores.fe.starmap.viewer.models.ConverterData;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.starmap.StarmapImpl;
import com.shores.fe.starmap.viewer.views.MenuView;
import generated.Starmap;
import java.io.File;
import java.io.StringReader;
import java.util.logging.Level;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;

public class MenuController implements IController{
    private SOH_FE_Converter core;
    private ConverterData model = null;
    private static final Logger LOG = Logger.getLogger(BBCodeExporterController.class.getName());
    private static MenuController instance = null;

    private MenuController() {
    }

    public static MenuController getInstance() {
            if (instance == null) {
                    instance = new MenuController();
            }
            return instance;
    }

    @Override
    public void init(AbstractModel model, SOH_FE_Converter core) {
        this.model = (ConverterData) model;
        this.core = core;
    }
    
    public ConverterData getModel() {
        return model;
    }
    
    public void loadXMLFromClipBoard(String data){
        StringReader reader = new StringReader(data);
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(Starmap.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Starmap starmap = (Starmap) unmarshaller.unmarshal(reader);
            
            model.setStarmap(new StarmapImpl(starmap));
            /*
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(starmap, System.out);
            */
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadXMLFromFile(File file){
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(Starmap.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Starmap starmap = (Starmap) unmarshaller.unmarshal(file);
            
            model.setStarmap(new StarmapImpl(starmap));
            model.computeNewTreeRoot();
/*
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(starmap, System.out);
            */
            
            model.notifyObservers(FeedbackCode.MAIN_DATA_CHANGED);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handleShowSearchFieldsAction(boolean b) {
        model.setShowViewSearch(b);
    }

    public void handleShowTableTreeAction(boolean b) {
        model.setShowViewTableTree(b);
    }

    public void handleShowExporterAction(boolean b) {
        model.setShowViewExporter(b);
    }
    
    public SOH_FE_Converter getCore() {
        return core;
    }
}
