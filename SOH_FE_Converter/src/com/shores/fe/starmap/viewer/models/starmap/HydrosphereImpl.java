package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import generated.Hydrosphere;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class HydrosphereImpl implements ITreeItemSOH{
    /** Parent */
    PlanetImpl planet;
    /** Data Holder */
    Hydrosphere hydrosphere;
    /** Children */
    List<ResourceImpl> resources = new ArrayList<>();
    
    HydrosphereImpl(PlanetImpl planet, Hydrosphere hydrosphere) {
        this.planet = planet;
        this.hydrosphere = hydrosphere;
        
        resources.add(new ResourceImpl(this, hydrosphere.getResource()));
    }

    @Override
    public TreeItem<ITreeItemSOH> getTreeItem() {
        TreeItem<ITreeItemSOH> treeRoot = new TreeItem<>(this);
        for (ResourceImpl resource : resources){
            treeRoot.getChildren().add(resource.getTreeItem());
        }
        return treeRoot;
    }
    
    @Override
    public String getName() {
        return "Hydrosphere (" + hydrosphere.getSurfaceLiquid() + ")";
    }

    @Override
    public String getCoordinates() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Hydrosphere;
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
    public String getExportBBCode() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public ITreeItemSOH getParent() {
        return planet;
    }

    @Override
    public boolean isValidData() {
        if (resources.isEmpty()) return false;
        return true;
    }
}