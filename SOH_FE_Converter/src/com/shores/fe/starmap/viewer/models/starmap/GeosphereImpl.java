package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Atmosphere;
import generated.Geosphere;
import generated.Resource;
import javafx.scene.control.TreeItem;

public class GeosphereImpl extends Geosphere implements ITreeItemSOH{
    Geosphere geosphere;
    GeosphereImpl(Geosphere geosphere) {
        this.geosphere = geosphere;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(
                "Geosphere " + "("  + geosphere.getDiameter()+ ")",
                SOHObjectType.Geosphere,
                ""
                ));
        
        for (Resource resource : geosphere.getResource()){
             treeRoot.getChildren().add(new ResourceImpl(resource).getTreeItem());
        }
        return treeRoot;
    }
    
}