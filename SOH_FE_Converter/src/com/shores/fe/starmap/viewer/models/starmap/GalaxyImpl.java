package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Galaxy;
import generated.Sector;
import javafx.scene.control.TreeItem;

public class GalaxyImpl extends Galaxy implements ITreeItemSOH{
    Galaxy galaxy = null;
    
    GalaxyImpl(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(galaxy.getName(), SOHObjectType.Galaxy, "")); //, depIcon);
        for (Sector sector : galaxy.getSector()) {
            treeRoot.getChildren().add(new SectorImpl(sector).getTreeItem());
        }
        return treeRoot;
    }
}
