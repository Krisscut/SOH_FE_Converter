package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Planet;
import javafx.scene.control.TreeItem;

public class PlanetImpl extends Planet implements ITreeItemSOH{

    generated.Planet planet = null;

    PlanetImpl(Planet planet) {
        this.planet = planet;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        SOHObjectType type = SOHObjectType.Planet;
        switch(planet.getBodyType()){
            case "Moon":
                type = SOHObjectType.Moon;
                break;
            case "Planet":
                type = SOHObjectType.Planet;
                
        }
        
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(
                planet.getName()+ " (id : " + planet.getPlanetId() + ")",
                type,
                planet.getOrbit(),
                planet.getZone()
                )); //, depIcon);
        
        if (planet.getAtmosphere() != null) {
            treeRoot.getChildren().add(new AtmosphereImpl(planet.getAtmosphere()).getTreeItem());
        }
        if (planet.getBiosphere() != null) {
             treeRoot.getChildren().add(new BiosphereImpl(planet.getBiosphere()).getTreeItem());
        }
        if (planet.getGeosphere() != null){
            treeRoot.getChildren().add(new GeosphereImpl(planet.getGeosphere()).getTreeItem());
        }
        if (planet.getHydrosphere() != null){
            treeRoot.getChildren().add(new HydrosphereImpl(planet.getHydrosphere()).getTreeItem());
        }
        return treeRoot;
    }
    
}