package com.shores.fe.starmap.viewer.models.starmap.enums;

public enum SOHZoneType {
    Inferno("F70707"),
    Inner("F79B07"),
    Habitable("7BD187"),
    Outer("07C3F7"),
    Frigid("6A4AED"),
    Unknown("6B7F85"),
    NA("6B7F85");
    
    private String hexColor;

    SOHZoneType(String hexColor) {
        this.hexColor = hexColor;
    }

    public String getColor(){
        return hexColor;
    }
    
    
    @Override
    public String toString(){
        if ( this == NA) {
            return "";
        } else {
            return this.name();
        }
    }

    
    public static SOHZoneType fromString (String string){
        for (SOHZoneType value : SOHZoneType.values()){
            if (string.contains(value.name())){
                return value;
            }
        }
        return Unknown;
    }
}
