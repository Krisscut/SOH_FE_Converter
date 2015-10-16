package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.export.ExportResult;
import generated.Atmosphere;
import generated.Resource;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class AtmosphereImpl implements ITreeItemSOH{
    /** Parent */
    PlanetImpl planet;
    /** Data holder */
    Atmosphere atmosphere;
    /** Children */
    List<ResourceImpl> resources = new ArrayList<>();
    
    AtmosphereImpl(PlanetImpl planet, Atmosphere atmosphere) {
        this.planet = planet;
        this.atmosphere = atmosphere;
        
        for (Resource resource : atmosphere.getResource()){
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
        return "Atmosphere " + "("  + atmosphere.getComposition() + ")";
    }

    @Override
    public String getCoordinates() {
        return "";
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Atmosphere;
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
        return planet;    /** Starmap is the root node */
    }
    
    @Override
    public boolean isValidData() {
        if (resources.isEmpty()) return false;
        return true;
    }
}
