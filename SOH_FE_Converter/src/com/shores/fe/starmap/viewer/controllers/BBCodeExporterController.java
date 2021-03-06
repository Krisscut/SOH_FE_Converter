package com.shores.fe.starmap.viewer.controllers;

import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.IController;
import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.AbstractModel;
import com.shores.fe.starmap.viewer.models.ConverterData;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;
import com.shores.fe.starmap.viewer.utils.DialogUtils;
import javafx.scene.control.TreeItem;
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

    public void handleExportAll(){
        DialogUtils.notImplementedYetDialog();
        /*
        model.setGeneratedBBCode(model.generateBBCode(model.getStarmap().getTreeItem()));
        model.notifyObservers(FeedbackCode.BBCODE_GENERATED);
        */
    }

    public void handleExportSelection() {
        TreeItem<ITreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH("Root", SOHObjectType.Unknown, ""));
        for (TreeItem<ITreeItemSOH> item : model.getCurrentSelection() ) {
            treeRoot.getChildren().add(item);
        }
        model.setGeneratedBBCode(model.generateBBCode(treeRoot));
        model.notifyObservers(FeedbackCode.BBCODE_GENERATED);
    }

    public void handleFilteredExport() {
        DialogUtils.notImplementedYetDialog();
        /*
        model.setGeneratedBBCode(model.generateBBCode(model.getTreeRoot()));
        model.notifyObservers(FeedbackCode.BBCODE_GENERATED);
                */
    }
    
    public SOH_FE_Converter getCore() {
        return core;
    }
}
