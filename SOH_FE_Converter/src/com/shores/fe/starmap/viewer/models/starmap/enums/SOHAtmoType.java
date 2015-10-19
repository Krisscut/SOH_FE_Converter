package com.shores.fe.starmap.viewer.models.starmap.enums;

public enum SOHAtmoType {
    Insidious("D98D29"),
    Standart("29D95E"),
    Tainted("29D9D9"),
    Unknown("6B7F85"),
    NA("6B7F85");
    
    private String hexColor;

    SOHAtmoType(String hexColor) {
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

    public static SOHAtmoType fromString (String string){
        for (SOHAtmoType value : SOHAtmoType.values()){
            if (string.contains(value.name())){
                return value;
            }
        }
        return Unknown;
    }
}
