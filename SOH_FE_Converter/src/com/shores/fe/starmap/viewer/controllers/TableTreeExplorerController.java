
package com.shores.fe.starmap.viewer.controllers;

import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.IController;
import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.AbstractModel;
import com.shores.fe.starmap.viewer.models.ConverterData;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import org.apache.log4j.Logger;


public class TableTreeExplorerController implements IController{
    private SOH_FE_Converter core;
    private ConverterData model = null;

    private static final Logger LOG = Logger.getLogger(TableTreeExplorerController.class.getName());
    private static TableTreeExplorerController instance = null;

    private TableTreeExplorerController() {
    }

    public static TableTreeExplorerController getInstance() {
            if (instance == null) {
                    instance = new TableTreeExplorerController();
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

    public void setModel(ConverterData model) {
        this.model = model;
    }

    public void treeSelectionChanged(ObservableList<TreeItem<ITreeItemSOH>> selectedItems) {
        model.setCurrentSelection(selectedItems);
    }

    public SOH_FE_Converter getCore() {
        return core;
    }
}