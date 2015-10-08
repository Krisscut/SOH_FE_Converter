
package com.shores.fe.starmap.viewer.controllers;

import com.shores.fe.starmap.viewer.interfaces.IController;
import com.shores.fe.starmap.viewer.models.AbstractModel;
import com.shores.fe.starmap.viewer.models.ConverterData;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import org.apache.log4j.Logger;


public class TableTreeExplorerController implements IController{
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
    public void init(AbstractModel model) {
        this.model = (ConverterData) model;
    }
    
    public ConverterData getModel() {
        return model;
    }

    public void setModel(ConverterData model) {
        this.model = model;
    }

    public void treeSelectionChanged(ObservableList<TreeItem<TreeItemSOH>> selectedItems) {
        model.setCurrentSelection(selectedItems);
    }
    
}