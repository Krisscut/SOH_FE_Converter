package com.shores.fe.starmap.viewer.utils;

public class QualityUtils {
    
    public static int QualityToTechLevel(int quality){
        return ((quality) / 8) +1;
    }
    
    public static int GetBestQualityInt(Integer[] qualities){
        int max = 0;
        for (Integer quality: qualities) {
            if (quality != null) {
                if (quality > max ) max = quality;
            }
        }
        return max;
    }
    
    public static String GetBestQualityZone(Integer[] qualities){
        int zone = -1;
        for (int i = 0 ; i < qualities.length; i++) {
            if (qualities[i] != null) {
                if (zone == -1) {
                    zone = i;
                }
                else {
                    if (qualities[i] > qualities[zone] ) zone = i;
                }
            }
        }
        if (zone == -1) return null;
        else {
            return "Zone " + (zone + 1);
        }
    }
}
