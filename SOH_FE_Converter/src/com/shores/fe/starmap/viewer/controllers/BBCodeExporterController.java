package com.shores.fe.starmap.viewer.controllers;

import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.IController;
import com.shores.fe.starmap.viewer.models.AbstractModel;
import com.shores.fe.starmap.viewer.models.ConverterData;
import com.shores.fe.starmap.viewer.utils.DialogUtils;
import org.apache.log4j.Logger;


public class BBCodeExporterController implements IController{
    private SOH_FE_Converter core;
    private ConverterData model = null;
    private static final Logger LOG = Logger.getLogger(BBCodeExporterController.class.getName());
    private static BBCodeExporterController instance = null;

    private BBCodeExporterController() {
    }

    public static BBCodeExporterController getInstance() {
            if (instance == null) {
                    instance = new BBCodeExporterController();
            }
            return instance;
    }

    @Override
    public void init(AbstractModel model, SOH_FE_Converter core) {
        this.model = (ConverterData) model;
        this.core = core;
    }
    
    public ConverterData getModel(){
        return model;
    }

    public void handleExportSelection() {
        if (model.getCurrentSelection() == null || model.getCurrentSelection().isEmpty()){
            DialogUtils.showInformationNotification("Error with user input", "No selection in the table ...");
        }
        model.setGeneratedBBCode(model.generateBBCode());
    }
    
    public SOH_FE_Converter getCore() {
        return core;
    }
}
