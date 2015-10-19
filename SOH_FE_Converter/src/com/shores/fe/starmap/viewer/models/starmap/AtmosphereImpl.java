package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHAtmoType;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import generated.Atmosphere;
import generated.Resource;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class AtmosphereImpl extends TreeItemSOH implements ITreeItemSOH{
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
    public SOHObjectType getType() {
        return SOHObjectType.Atmosphere;
    }
    
    @Override
    public SOHAtmoType getAtmoType(){
        return SOHAtmoType.fromString(atmosphere.getComposition());
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
