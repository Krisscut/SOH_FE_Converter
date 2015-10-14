package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Wormhole;
import javafx.scene.control.TreeItem;

public class WormholeImpl implements ITreeItemSOH{

    @Override
    public TreeItem<ITreeItemSOH> getTreeItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getName() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public String getCoordinates() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Starmap;
    }

    @Override
    public String getZone() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public String getQualityZone1() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public String getQualityZone2() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public String getQualityZone3() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public String getExportBBCode() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public ITreeItemSOH getParent() {
        return null;    /** Starmap is the root node */
    }
    
    @Override
    public boolean isValidData() {
        return true;
    }
}