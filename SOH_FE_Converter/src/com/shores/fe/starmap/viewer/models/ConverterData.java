package com.shores.fe.starmap.viewer.models;

import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;
import com.shores.fe.starmap.viewer.models.starmap.StarmapImpl;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class ConverterData extends AbstractModel{
    StarmapImpl starmap = null;
    
    TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH("My Body", SOHObjectType.Unknown, "coordinates")); //, depIcon);
    ObservableList<TreeItem<TreeItemSOH>> currentSelection = null;
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
    
    public void setCurrentSelection(ObservableList<TreeItem<TreeItemSOH>> selectedItems) {
        currentSelection = selectedItems;
    }
    
    public ObservableList<TreeItem<TreeItemSOH>> getCurrentSelection() {
        return currentSelection;
    }
    

    public StarmapImpl getStarmap() {
        return starmap;
    }

    public void setStarmap(StarmapImpl starmap) {
        this.starmap = starmap;
    }

    public TreeItem<TreeItemSOH> getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeItem<TreeItemSOH> treeRoot) {
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

    public String generateBBCode(TreeItem<TreeItemSOH> treeItem) {
        String tmpBBCode = treeItem.getValue().toString();
        for (TreeItem<TreeItemSOH> item : treeItem.getChildren()) {
            tmpBBCode += "\n";
            tmpBBCode += generateBBCode(item);
        }
        return tmpBBCode;
    }
}
