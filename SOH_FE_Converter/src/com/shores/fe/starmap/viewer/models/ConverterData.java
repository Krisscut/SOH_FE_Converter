package com.shores.fe.starmap.viewer.models;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;
import com.shores.fe.starmap.viewer.models.starmap.StarmapImpl;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class ConverterData extends AbstractModel{
    StarmapImpl starmap = null;
    
    /** Views state */
    boolean showViewSearch = true;
    boolean showViewTableTree = true;
    boolean showViewExporter = true;
    
    TreeItem<ITreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH("My Body", SOHObjectType.Unknown, "coordinates")); //, depIcon);
    ObservableList<TreeItem<ITreeItemSOH>> currentSelection = null;
    String generatedBBCode = "";
    
    /** 
     * Creates a new root for the tree, using filtering options etc
     */
    public void computeNewTreeRoot() {
        treeRoot = starmap.getTreeItem();
    }
    
    /*
        GETTERS & SETTERS
    */
    
    public void setCurrentSelection(ObservableList<TreeItem<ITreeItemSOH>> selectedItems) {
        currentSelection = selectedItems;
    }
    
    public ObservableList<TreeItem<ITreeItemSOH>> getCurrentSelection() {
        return currentSelection;
    }
    

    public StarmapImpl getStarmap() {
        return starmap;
    }

    public void setStarmap(StarmapImpl starmap) {
        this.starmap = starmap;
    }

    public TreeItem<ITreeItemSOH> getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeItem<ITreeItemSOH> treeRoot) {
        this.treeRoot = treeRoot;
    }

    public String getGeneratedBBCode() {
        return generatedBBCode;
    }

    public void setGeneratedBBCode(String generatedBBCode) {
        this.generatedBBCode = generatedBBCode;
    }
    
    public void resetGeneratedBBCode(){
        this.generatedBBCode = "";
    }

    public String generateBBCode(TreeItem<ITreeItemSOH> treeItem) {
        ITreeItemSOH tmpItem = treeItem.getValue();
        String tmpBBCode = "";
        if (tmpItem.getType() == SOHObjectType.Resource ){
            tmpBBCode = treeItem.getValue().getExportBBCode();
        }
        for (TreeItem<ITreeItemSOH> item : treeItem.getChildren()) {
            if (!tmpBBCode.isEmpty()) tmpBBCode += "\n";
            tmpBBCode += generateBBCode(item);
        }
        return tmpBBCode;
    }

    public boolean isShowViewSearch() {
        return showViewSearch;
    }

    public void setShowViewSearch(boolean showViewSearch) {
        this.showViewSearch = showViewSearch;
        notifyObservers(FeedbackCode.SEARCH_VIEW_CHANGED);
    }

    public boolean isShowViewTableTree() {
        return showViewTableTree;
    }

    public void setShowViewTableTree(boolean showViewTableTree) {
        this.showViewTableTree = showViewTableTree;
        notifyObservers(FeedbackCode.TREETABLE_VIEW_CHANGED);
    }

    public boolean isShowViewExporter() {
        return showViewExporter;
    }

    public void setShowViewExporter(boolean showViewExporter) {
        this.showViewExporter = showViewExporter;
        notifyObservers(FeedbackCode.EXPORTER_VIEW_CHANGED);
    }
    
    
}
