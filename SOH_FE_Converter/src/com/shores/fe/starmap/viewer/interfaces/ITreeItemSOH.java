package com.shores.fe.starmap.viewer.interfaces;

import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;
import javafx.scene.control.TreeItem;

public interface ITreeItemSOH {
    public String DEFAULT_VALUE_STRING = "";
    public Integer DEFAULT_VALUE_INTEGER = null;
    
    public TreeItem<ITreeItemSOH> getTreeItem();
    
    public String getName();
    
    public String getCoordinates();

    public SOHObjectType getType();

    public String getZone();
    
    public Integer getQualityZone1();
        
    public Integer getQualityZone2();
            
    public Integer getQualityZone3();
    
    public String getExportBBCode();
    
    public ITreeItemSOH getParent();
    
    /** Checks if the data contained into the model is usefull ( item without child ressources can be deleted ! )*/
    public boolean isValidData();
}
