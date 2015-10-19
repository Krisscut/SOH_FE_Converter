package com.shores.fe.starmap.viewer.models.starmap.enums;

public enum SOHObjectType {
    Starmap("A72DCF"),
    Galaxy("2DA6CF"),
    Sector("D6865E"),
    System("CF27BB"),
    PlanetOrStar("3E3E45"),
    Planet("CF2751"),
    Star("CFAD27"),
    Moon("B3B0A4"),
    Atmosphere("24D6E3"),
    Biosphere("55CF2D"),
    Geosphere("CF9C2D"),
    Hydrosphere("2474E3"),
    Resource("27CF94"),
    Unknown("D6865E");
    
    private String hexColor;

    SOHObjectType(String hexColor) {
        this.hexColor = hexColor;
    }

    public String getColor(){
        return hexColor;
    }
    
    public static SOHObjectType fromString (String string){
        for (SOHObjectType value : SOHObjectType.values()){
            if (string.contains(value.name())){
                return value;
            }
        }
        return Unknown;
    }
}
