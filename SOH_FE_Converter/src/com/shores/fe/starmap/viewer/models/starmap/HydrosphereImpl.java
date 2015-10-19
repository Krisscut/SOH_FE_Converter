package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import generated.Hydrosphere;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class HydrosphereImpl extends TreeItemSOH implements ITreeItemSOH{
    /** Parent */
    PlanetImpl planet;
    /** Data Holder */
    Hydrosphere hydrosphere;
    /** Children */
    List<ResourceImpl> resources = new ArrayList<>();
    
    HydrosphereImpl(PlanetImpl planet, Hydrosphere hydrosphere) {
        this.planet = planet;
        this.hydrosphere = hydrosphere;
        
        if (hydrosphere.getResource() != null){
            resources.add(new ResourceImpl(this, hydrosphere.getResource()));
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
        return "Hydrosphere (" + hydrosphere.getSurfaceLiquid() + ")";
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Hydrosphere;
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