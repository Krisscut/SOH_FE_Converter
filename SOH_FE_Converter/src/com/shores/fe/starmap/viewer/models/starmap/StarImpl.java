package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import generated.Star;
import javafx.scene.control.TreeItem;

public class StarImpl implements ITreeItemSOH{
    /** Parent */
    SystemImpl system;
    /** Data holder */
    Star star = null;
    /** Children */
    ResourceImpl resource;
    
    StarImpl(SystemImpl system, Star star) {
        this.system = system;
        this.star = star;
        
        resource = new ResourceImpl(this, star.getResource());
    }

    @Override
    public TreeItem<ITreeItemSOH> getTreeItem() {
        TreeItem<ITreeItemSOH> treeRoot = new TreeItem<>(this);
        treeRoot.getChildren().add(resource.getTreeItem());
        return treeRoot;
    }
    
    @Override
    public String getName() {
        return star.getName()+ " (id : " + star.getStarId()+ ")";
    }

    @Override
    public String getCoordinates() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Star;
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
        return system;
    }

    @Override
    public boolean isValidData() {
        return resource.isValidData();
    }
    
}
