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
                sector.getName()+ " Sector (id : " + sector.getSectorId() + ")",
                SOHObjectType.Sector,
                "[" + sector.getX() + "," + sector.getY() + "," + sector.getZ() + "]")); //, depIcon);
        /**
        for (Sector sector : galaxy.getSector()) {
            treeRoot.getChildren().add(new SectorImpl(sector).getTreeItem());
        }
        */
        return treeRoot;
    }
    
}