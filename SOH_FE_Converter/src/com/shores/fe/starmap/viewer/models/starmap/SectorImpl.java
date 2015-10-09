package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Sector;
import javafx.scene.control.TreeItem;

public class SectorImpl extends Sector implements ITreeItemSOH{
    Sector sector = null;

    SectorImpl(Sector sector) {
        this.sector = sector;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(
                sector.getName()+ " (id : " + sector.getSectorId() + ")",
                SOHObjectType.Sector,
                "[" + sector.getX() + "," + sector.getY() + "," + sector.getZ() + "]")); //, depIcon);
        for (generated.System system : sector.getSystem()) {
            treeRoot.getChildren().add(new SystemImpl(system).getTreeItem());
        }
        return treeRoot;
    }
    
}