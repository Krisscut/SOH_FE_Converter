package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Galaxy;
import generated.Starmap;
import javafx.scene.control.TreeItem;

public class StarmapImpl extends Starmap  implements ITreeItemSOH{
    Starmap starmap = null;
    
    public StarmapImpl(Starmap starmap) {
        this.starmap = starmap;
    }

    public TreeItem<TreeItemSOH> getTreeItem() {
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(starmap.getEmpire() + " Starmap",
                SOHObjectType.Starmap,
                "")); //, depIcon);
        for (Galaxy galaxy : starmap.getGalaxy()) {
            treeRoot.getChildren().add(new GalaxyImpl(galaxy).getTreeItem());
        }
        return treeRoot;
    }
    
}
