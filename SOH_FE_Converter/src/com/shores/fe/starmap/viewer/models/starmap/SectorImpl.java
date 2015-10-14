package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import generated.Sector;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class SectorImpl implements ITreeItemSOH{
    /** Parent */
    GalaxyImpl galaxy;
    
    /** Data holder */
    Sector sector;
    
    /** Precomputed childs */
    List<SystemImpl> systems = new ArrayList<>();

    SectorImpl(GalaxyImpl galaxy, Sector sector) {
        this.sector = sector;
        
        for (generated.System system : sector.getSystem()) {
            systems.add(new SystemImpl(this,system));
        }
    }

    @Override
    public TreeItem<ITreeItemSOH> getTreeItem() {
        TreeItem<ITreeItemSOH> treeRoot = new TreeItem<>(this); //, depIcon);
        for (SystemImpl system : systems) {
            treeRoot.getChildren().add(system.getTreeItem());
        }
        return treeRoot;
    }
    
    @Override
    public String getName() {
        return sector.getName();
    }
    
    @Override
    public String getCoordinates() {
        return "[" + sector.getX() + "," + sector.getY() + "," + sector.getZ() + "]";
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Sector;
    }

    @Override
    public String getZone() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public String getQualityZone1() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public String getQualityZone2() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public String getQualityZone3() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public String getExportBBCode() {
        return toString();
    }

    @Override
    public ITreeItemSOH getParent() {
        return galaxy;
    }
    
    @Override
    public boolean isValidData() {
        boolean test = false;
        ArrayList<Object> toRemove = new ArrayList<>();
        for (SystemImpl systemImpl : systems) {
            if (systemImpl.isValidData()) test = true;
            else toRemove.add(systemImpl);
        }
        systems.removeAll(toRemove);
        return test;
    }
}