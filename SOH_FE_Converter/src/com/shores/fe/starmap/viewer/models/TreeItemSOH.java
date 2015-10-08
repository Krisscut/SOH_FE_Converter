package com.shores.fe.starmap.viewer.models;

import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;

public class TreeItemSOH {
    String name;
    SOHObjectType type;
    String coordinates;

    public TreeItemSOH(String name, SOHObjectType type, String coordinates) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCoordinates(){
        return coordinates;
    }

    public String getType() {
        if (type == null){
            return SOHObjectType.Unknown.name();
        }
        return type.name();
    }

    @Override
    public String toString() {
        
        return "TreeItemSOH{" + "name=" + name + ", type=" + type + ", coordinates=" + coordinates + '}';
    }
}
