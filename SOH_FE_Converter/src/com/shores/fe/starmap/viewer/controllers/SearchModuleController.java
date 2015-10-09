package com.shores.fe.starmap.viewer.controllers;

import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.IController;
import com.shores.fe.starmap.viewer.models.AbstractModel;
import com.shores.fe.starmap.viewer.models.ConverterData;
import org.apache.log4j.Logger;

public class SearchModuleController implements IController{
    private SOH_FE_Converter core;
    private ConverterData model = null;
    private static final Logger LOG = Logger.getLogger(SearchModuleController.class.getName());
    private static SearchModuleController instance = null;

    private SearchModuleController() {
        
    }

    public static SearchModuleController getInstance() {
            if (instance == null) {
                    instance = new SearchModuleController();
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
    
    public SOH_FE_Converter getCore() {
        return core;
    }
    
}