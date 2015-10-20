package com.shores.fe.starmap.viewer.models;

import com.shores.fe.starmap.viewer.core.Configuration.Configuration;
import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.export.ExportResult;
import com.shores.fe.starmap.viewer.models.filtering.Filter;
import com.shores.fe.starmap.viewer.models.starmap.StarmapImpl;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class ConverterData extends AbstractModel{
    StarmapImpl starmap = null;
    
    /** Views state */
    boolean showViewSearch = true;
    boolean showViewTableTree = true;
    boolean showViewExporter = true;
    
    boolean isFilterActive = false;
    Filter currentFilter = new Filter();
    
    TreeItem<ITreeItemSOH> treeRoot = null; //new TreeItem<>(new TreeItemSOH("My Body", SOHObjectType.Unknown, "coordinates")); //, depIcon);
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
    
    public synchronized void setCurrentSelection(ObservableList<TreeItem<ITreeItemSOH>> selectedItems) {
        currentSelection = selectedItems;
    }
    
    public synchronized ObservableList<TreeItem<ITreeItemSOH>>  getCurrentSelection() {
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
        notifyObservers(FeedbackCode.BBCODE_GENERATED);
    }
    
    public void resetGeneratedBBCode(){
        this.generatedBBCode = "";
    }
    
    /** Generates the bbCode !*/
    public String generateBBCode() {
        List<ExportResult> globalList = new ArrayList<>();
        HashMap<String,String> sortedBBCode = new HashMap<>();
        
        //First, get all the export results
        for (TreeItem<ITreeItemSOH> item : getCurrentSelection()) {
            globalList.addAll(generateBBCode(item));
        }
        
        //Then, populate the hash map to sort the export result by resource.
        for (ExportResult result : globalList){
            if (sortedBBCode.containsKey(result.getExportType())){
                sortedBBCode.put(result.getExportType(), sortedBBCode.get(result.getExportType()) + Configuration.LINE_SEPARATOR + result.getResultExport());
            } else {
                sortedBBCode.put(result.getExportType(), result.getExportType() + Configuration.LINE_SEPARATOR + result.getResultExport());
            }
        }
        
        Metrics.SetExportCounter(globalList.size());
        
        String bbCodeGenerated = "";
        //Finally, concat all the section to generate the final bbCode
        for (String section : sortedBBCode.values()){
            bbCodeGenerated += section + Configuration.LINE_SEPARATOR;
        }
        return bbCodeGenerated;
    }

    /** old function */
    public List<ExportResult> generateBBCode(TreeItem<ITreeItemSOH> treeItem) {
        List<ExportResult> exportResults = new ArrayList<>();
        ITreeItemSOH tmpItem = treeItem.getValue();
        ExportResult exportResultTmp;
        if (tmpItem.getType() == SOHObjectType.Resource ){
            exportResults.add(treeItem.getValue().getExportBBCode());
        }
        for (TreeItem<ITreeItemSOH> item : treeItem.getChildren()) {
            exportResults.addAll(generateBBCode(item));
        }
        return exportResults;
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
