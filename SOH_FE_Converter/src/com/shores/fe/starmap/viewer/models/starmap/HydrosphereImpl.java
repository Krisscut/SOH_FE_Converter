package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Biosphere;
import generated.Hydrosphere;
import generated.Resource;
import javafx.scene.control.TreeItem;

public class HydrosphereImpl extends Hydrosphere implements ITreeItemSOH{

    Hydrosphere hydrosphere;
    HydrosphereImpl(Hydrosphere hydrosphere) {
        this.hydrosphere = hydrosphere;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(
                "Hydrosphere (" + hydrosphere.getSurfaceLiquid() + ")",
                SOHObjectType.Hydrosphere,
                ""
                ));
        if (hydrosphere.getResource() != null) {
            treeRoot.getChildren().add(new ResourceImpl(hydrosphere.getResource()).getTreeItem());
        }
        return treeRoot;
    }
    
}