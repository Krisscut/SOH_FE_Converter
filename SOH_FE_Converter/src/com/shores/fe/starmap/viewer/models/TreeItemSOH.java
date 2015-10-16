package com.shores.fe.starmap.viewer.models;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.export.ExportResult;
import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;
import javafx.scene.control.TreeItem;

public class TreeItemSOH implements ITreeItemSOH{
    String name = "";
    SOHObjectType type = SOHObjectType.Unknown;
    String coordinates = "";
    String zone = ""; 
    Integer qualityZone1 = null;
    Integer qualityZone2 = null;
    Integer qualityZone3 = null;
    
    public TreeItemSOH(String name, SOHObjectType type, String coordinates) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
    }
    
    public TreeItemSOH(String name, SOHObjectType type, String coordinates, String zone) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
        this.zone = zone;
    }
    
    public TreeItemSOH(String name, SOHObjectType type, String coordinates, String zone, Integer qualityZone1, Integer qualityZone2, Integer qualityZone3) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
        this.zone = zone;
        this.qualityZone1 = qualityZone1;
        this.qualityZone2 = qualityZone2;
        this.qualityZone3 = qualityZone3;
    }
    public String getName(){
        return name;
    }
    
    public String getCoordinates(){
        return coordinates;
    }

    public SOHObjectType getType() {
        if (type == null){
            return SOHObjectType.Unknown;
        }
        return type;
    }

    public String getZone() {
        return this.zone;
    }
    
    public Integer getQualityZone1() {
        if (qualityZone1 == null){
            return null;
        }
        return qualityZone1;
    }
        
    @Override
    public Integer getQualityZone2() {
        if (qualityZone2 == null){
            return null;
        }
        return qualityZone2;
    }
            
    @Override
    public Integer getQualityZone3() {
        if (qualityZone3 == null){
            return null;
        }
        return qualityZone3;
    }

    @Override
    public TreeItem<ITreeItemSOH> getTreeItem() {
        return new TreeItem<>(this);
    }

    @Override
    public ExportResult getExportBBCode() {
        return new ExportResult("TreeItemSOH", toString());
    }

    @Override
    public ITreeItemSOH getParent() {
        return null; //no parent
    }

    @Override
    public boolean isValidData() {
        return true;
    }
}
