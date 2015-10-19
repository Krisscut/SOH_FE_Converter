package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import generated.Geosphere;
import generated.Resource;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class GeosphereImpl extends TreeItemSOH implements ITreeItemSOH{
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
    public SOHObjectType getType() {
        return SOHObjectType.Geosphere;
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