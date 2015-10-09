package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Atmosphere;
import generated.Resource;
import javafx.scene.control.TreeItem;

public class AtmosphereImpl extends Atmosphere  implements ITreeItemSOH{
    Atmosphere atmosphere;
    AtmosphereImpl(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(
                "Atmosphere " + "("  + atmosphere.getComposition() + ")",
                SOHObjectType.Atmosphere,
                ""
                ));
        
        for (Resource resource : atmosphere.getResource()){
             treeRoot.getChildren().add(new ResourceImpl(resource).getTreeItem());
        }
        return treeRoot;
    }
}
