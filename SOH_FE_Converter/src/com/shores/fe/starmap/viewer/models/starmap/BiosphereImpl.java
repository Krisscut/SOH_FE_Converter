package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import generated.Biosphere;
import generated.Resource;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class BiosphereImpl extends TreeItemSOH implements ITreeItemSOH{
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
    public SOHObjectType getType() {
        return SOHObjectType.Biosphere;
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
