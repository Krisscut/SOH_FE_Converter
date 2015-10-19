package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import generated.Galaxy;
import generated.Sector;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class GalaxyImpl extends TreeItemSOH implements ITreeItemSOH{
    /** Parent */
    StarmapImpl starmap;
    /** Memo data */
    Galaxy galaxy;
    /** Children */
    List<SectorImpl> sectors = new ArrayList<>();;
    
    GalaxyImpl(StarmapImpl starmap,Galaxy galaxy) {
        this.galaxy = galaxy;
        for (Sector sector : galaxy.getSector()) {
            sectors.add(new SectorImpl(this, sector));
        }
    }
    
    @Override
    public TreeItem<ITreeItemSOH> getTreeItem() {
        TreeItem<ITreeItemSOH> treeRoot = new TreeItem<>(this); //, depIcon);
        for (SectorImpl sector : sectors) {
            treeRoot.getChildren().add(sector.getTreeItem());
        }
        return treeRoot;
    }
    @Override
    public String getName() {
        return galaxy.getName();
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Galaxy;
    }

    @Override
    public ITreeItemSOH getParent() {
        return starmap;
    }
    
    @Override
    public boolean isValidData() {
        boolean test = false;
        ArrayList<Object> toRemove = new ArrayList<>();
        for (SectorImpl sector : sectors) {
            if (sector.isValidData()) test = true;
            else toRemove.add(sector);
        }
        sectors.removeAll(toRemove);
        return test;
    }
}
