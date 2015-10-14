package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import generated.Planet;
import javafx.scene.control.TreeItem;

public class PlanetImpl implements ITreeItemSOH{
    /** Parent*/
    SystemImpl system;
    /** Data holder */
    generated.Planet planet = null;
    /** Children */
    AtmosphereImpl atmosphere;
    BiosphereImpl biosphere;
    GeosphereImpl geosphere;
    HydrosphereImpl hydrosphere;
    
    PlanetImpl(SystemImpl system, Planet planet) {
        this.system = system;
        this.planet = planet;
        
        if (planet.getAtmosphere() != null) {
            atmosphere = new AtmosphereImpl(this, planet.getAtmosphere());
        }
        if (planet.getBiosphere() != null) {
            biosphere = new BiosphereImpl(this, planet.getBiosphere());
        }
        if (planet.getGeosphere() != null){
            geosphere = new GeosphereImpl(this, planet.getGeosphere());
        }
        if (planet.getHydrosphere() != null){
            hydrosphere = new HydrosphereImpl(this, planet.getHydrosphere());
        }
    }

    @Override
    public TreeItem<ITreeItemSOH> getTreeItem() {
        TreeItem<ITreeItemSOH> treeRoot = new TreeItem<>(this);
        
        if (atmosphere != null) {
            treeRoot.getChildren().add(atmosphere.getTreeItem());
        }
        if (biosphere != null) {
            treeRoot.getChildren().add(biosphere.getTreeItem());
        }
        if (geosphere != null){
            treeRoot.getChildren().add(geosphere.getTreeItem());
        }
        if (hydrosphere != null){
            treeRoot.getChildren().add(hydrosphere.getTreeItem());
        }
        return treeRoot;
    }
    
    @Override
    public String getName() {
        return planet.getName();
    }

    @Override
    public String getCoordinates() {
        return planet.getOrbit();
    }

    @Override
    public SOHObjectType getType() {
        SOHObjectType type = SOHObjectType.Planet;
        switch(planet.getBodyType()){
            case "Moon":
                type = SOHObjectType.Moon;
                break;
            case "Planet":
                type = SOHObjectType.Planet;
        }
        return type;
    }

    @Override
    public String getZone() {
        return planet.getZone();
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
        return system;
    }

    @Override
    public boolean isValidData() {
        boolean test = false;
        if (atmosphere != null) {
            if (atmosphere.isValidData()) test = true;
            else atmosphere = null;
        }
        if (biosphere != null) {
            if (biosphere.isValidData()) test = true;
            else biosphere = null;
        }
        if (geosphere != null){
            if (geosphere.isValidData()) test = true;
            else geosphere = null;
        }
        if (hydrosphere != null){
            if (hydrosphere.isValidData()) test = true;
            else hydrosphere = null;
        }
        return test;
    }
    
}