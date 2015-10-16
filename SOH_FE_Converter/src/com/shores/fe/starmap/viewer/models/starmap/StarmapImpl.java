package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.export.ExportResult;
import generated.Galaxy;
import generated.Starmap;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class StarmapImpl implements ITreeItemSOH{
    /** Memo xml data */ 
    Starmap starmap = null;
    
    /** Memo */
    List<GalaxyImpl> galaxies = new ArrayList<>();
    
    public StarmapImpl(Starmap starmap) {
        this.starmap = starmap;
        
        for (Galaxy galaxy : starmap.getGalaxy()) {
            galaxies.add(new GalaxyImpl(this, galaxy));
        }
    }

    public TreeItem<ITreeItemSOH> getTreeItem() {
        TreeItem<ITreeItemSOH> treeRoot = new TreeItem<>(this); //, depIcon);
        for (GalaxyImpl galaxy : galaxies) {
            treeRoot.getChildren().add(galaxy.getTreeItem());
        }
        return treeRoot;
    }

    @Override
    public String getName() {
        return starmap.getEmpire();
    }

    @Override
    public String getCoordinates() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Starmap;
    }

    @Override
    public String getZone() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public Integer getQualityZone1() {
        return DEFAULT_VALUE_INTEGER;
    }

    @Override
    public Integer getQualityZone2() {
        return DEFAULT_VALUE_INTEGER;
    }

    @Override
    public Integer getQualityZone3() {
        return DEFAULT_VALUE_INTEGER;
    }

    @Override
    public ExportResult getExportBBCode() {
        return DEFAULT_EXPORT_RESULT;
    }

    @Override
    public ITreeItemSOH getParent() {
        return null;    /** Starmap is the root node */
    }
    
    @Override
    public boolean isValidData() {
        boolean test = false;
        ArrayList<Object> toRemove = new ArrayList<>();
        for (GalaxyImpl galaxy : galaxies) {
            if (galaxy.isValidData()) test = true;
            else toRemove.add(galaxy);
        }
        galaxies.removeAll(toRemove);
        return test;
    }
}
