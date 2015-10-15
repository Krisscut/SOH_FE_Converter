package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import generated.Biosphere;
import generated.Resource;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class BiosphereImpl implements ITreeItemSOH{
    /** Parent */
    PlanetImpl planet;
    /** Data holder */
    Biosphere biosphere;
    /** Children */
    List<ResourceImpl> resources = new ArrayList<>();
    
    BiosphereImpl(PlanetImpl planet, Biosphere biosphere) {
        this.planet = planet;
        this.biosphere = biosphere;
        
        for (Resource resource : biosphere.getResource()){
            resources.add(new ResourceImpl(this, resource));
        }
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
        return "Biosphere";
    }

    @Override
    public String getCoordinates() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Biosphere;
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
