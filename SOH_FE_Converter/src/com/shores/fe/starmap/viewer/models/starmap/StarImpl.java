package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import generated.Star;
import javafx.scene.control.TreeItem;

public class StarImpl extends TreeItemSOH implements ITreeItemSOH{
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
    public SOHObjectType getType() {
        return SOHObjectType.Star;
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
