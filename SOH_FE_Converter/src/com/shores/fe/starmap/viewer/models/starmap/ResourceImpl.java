package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Resource;
import javafx.scene.control.TreeItem;

public class ResourceImpl extends Resource implements ITreeItemSOH{

    Resource resource;
    ResourceImpl(Resource resource) {
        this.resource = resource;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        String resourceQuality1 = "";
        String resourceQuality2 = "";
        String resourceQuality3 = "";
        
        if (resource.getQualityZone1() == null && resource.getQualityZone2() == null && resource.getQualityZone3() == null) {
            resourceQuality1 = resource.getQuality() + "";
            resourceQuality2 = resource.getQuality() + "";
            resourceQuality3 = resource.getQuality() + "";
        } else {
            if (resource.getQualityZone1() != null) resourceQuality1 = resource.getQuality() + "";
            if (resource.getQualityZone2() != null) resourceQuality2 = resource.getQualityZone2() + "";
            if (resource.getQualityZone3() != null) resourceQuality3 = resource.getQualityZone3() + "";
        }
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(
                resource.getName(),
                SOHObjectType.Resource,
                "",
                "",
                resourceQuality1,
                resourceQuality2,
                resourceQuality3
                ));   
        return treeRoot;
    }
    
}