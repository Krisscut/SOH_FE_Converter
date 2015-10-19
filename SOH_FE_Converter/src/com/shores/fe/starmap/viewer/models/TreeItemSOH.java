package com.shores.fe.starmap.viewer.models;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.export.ExportResult;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHAtmoType;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHZoneType;
import javafx.scene.control.TreeItem;

/**
 * Default implementation for the @see TreeItemSOH interface
 * ( return default values ... )
 */
public abstract class TreeItemSOH implements ITreeItemSOH{

    @Override
    public String getName(){
        return DEFAULT_VALUE_STRING;
    }
    
    @Override
    public String getCoordinates(){
        return DEFAULT_VALUE_STRING;
    }
    
    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Unknown;
    }

    @Override
    public SOHZoneType getZone() {
        return SOHZoneType.NA;
    }
    
    @Override
    public SOHAtmoType getAtmoType() {
        return SOHAtmoType.NA;
    }
    
    @Override
    public Integer getQualityZone1() {
        return DEFAULT_VALUE_INTEGER;
    }
        
    @Override
    public Integer getQualityZone2() {
        return DEFAULT_VALUE_INTEGER;
    }
            
    @Override
    public Integer getQualityZone3() {
        return DEFAULT_VALUE_INTEGER;
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
