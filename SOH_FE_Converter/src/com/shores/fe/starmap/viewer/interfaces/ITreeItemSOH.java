package com.shores.fe.starmap.viewer.interfaces;

import com.shores.fe.starmap.viewer.models.export.ExportResult;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHAtmoType;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHZoneType;
import javafx.scene.control.TreeItem;

public interface ITreeItemSOH {
    public String DEFAULT_VALUE_STRING = "";
    public Integer DEFAULT_VALUE_INTEGER = null;
    public ExportResult DEFAULT_EXPORT_RESULT = new ExportResult("Default", "Export result default");
    
    public TreeItem<ITreeItemSOH> getTreeItem();
    
    public String getName();
    
    public String getCoordinates();

    public SOHObjectType getType();

    public SOHZoneType getZone();
    
    public SOHAtmoType getAtmoType();
    
    public Integer getQualityZone1();
        
    public Integer getQualityZone2();
            
    public Integer getQualityZone3();
    
    public ExportResult getExportBBCode();
    
    public ITreeItemSOH getParent();
    
    /** Checks if the data contained into the model is usefull ( item without child ressources can be deleted ! )
     * @return boolean */
    public boolean isValidData();
}
