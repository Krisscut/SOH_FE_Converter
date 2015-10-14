package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import generated.Geosphere;
import generated.Resource;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class GeosphereImpl implements ITreeItemSOH{
    /** Parent */
    PlanetImpl planet;
    /** Data Holder */
    Geosphere geosphere;
    /** Children */
    List<ResourceImpl> resources = new ArrayList<>();
    
    GeosphereImpl(PlanetImpl planet, Geosphere geosphere) {
        this.planet = planet;
        this.geosphere = geosphere;
        
        for (Resource resource : geosphere.getResource()){
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
        return "Geosphere " + "("  + geosphere.getDiameter()+ ")";
    }

    @Override
    public String getCoordinates() {
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Geosphere;
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
        return DEFAULT_VALUE_STRING;
    }

    @Override
    public ITreeItemSOH getParent() {
        return null;    /** Starmap is the root node */
    }

    @Override
    public boolean isValidData() {
        if (resources.isEmpty()) return false;
        return true;
    }
}