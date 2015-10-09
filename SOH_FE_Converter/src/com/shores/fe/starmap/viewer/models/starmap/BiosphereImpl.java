package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Atmosphere;
import generated.Biosphere;
import generated.Resource;
import javafx.scene.control.TreeItem;

public class BiosphereImpl extends Biosphere implements ITreeItemSOH{

    Biosphere biosphere;
    BiosphereImpl(Biosphere biosphere) {
        this.biosphere = biosphere;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(
                "Biosphere",
                SOHObjectType.Biosphere,
                ""
                ));
        
        for (Resource resource : biosphere.getResource()){
             treeRoot.getChildren().add(new ResourceImpl(resource).getTreeItem());
        }
        return treeRoot;
    }
    
}
