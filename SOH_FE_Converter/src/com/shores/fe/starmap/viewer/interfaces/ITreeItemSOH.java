package com.shores.fe.starmap.viewer.interfaces;

import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;
import javafx.scene.control.TreeItem;

public interface ITreeItemSOH {
    public String DEFAULT_VALUE_STRING = "";
    
    public TreeItem<ITreeItemSOH> getTreeItem();
    
    public String getName();
    
    public String getCoordinates();

    public SOHObjectType getType();

    public String getZone();
    
    public String getQualityZone1();
        
    public String getQualityZone2();
            
    public String getQualityZone3();
    
    public String getExportBBCode();
    
    public ITreeItemSOH getParent();
    
    /** Checks if the data contained into the model is usefull ( item without child ressources can be deleted ! )*/
    public boolean isValidData();
}
