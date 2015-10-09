package com.shores.fe.starmap.viewer.models;

import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;

public class TreeItemSOH {
    String name = "";
    SOHObjectType type = SOHObjectType.Unknown;
    String coordinates = "";
    /** Habitable zone ... ) */
    String zone = ""; 
    String qualityZone1 = null;
    String qualityZone2 = null;
    String qualityZone3 = null;
    
    public TreeItemSOH(String name, SOHObjectType type, String coordinates) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
    }
    
    public TreeItemSOH(String name, SOHObjectType type, String coordinates, String zone) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
        this.zone = zone;
    }
    
    public TreeItemSOH(String name, SOHObjectType type, String coordinates, String zone, String qualityZone1, String qualityZone2, String qualityZone3) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
        this.zone = zone;
        this.qualityZone1 = qualityZone1;
        this.qualityZone2 = qualityZone2;
        this.qualityZone3 = qualityZone3;
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

    public String getZone() {
        return this.zone;
    }
    
    public String getQualityZone1() {
        if (qualityZone1 == null){
            return "";
        }
        return qualityZone1;
    }
        
    public String getQualityZone2() {
        if (qualityZone2 == null){
            return "";
        }
        return qualityZone2;
    }
            
    public String getQualityZone3() {
        if (qualityZone3 == null){
            return "";
        }
        return qualityZone3;
    }
}
