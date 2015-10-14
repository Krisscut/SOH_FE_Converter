package com.shores.fe.starmap.viewer.models;

public class Metrics {
    private static int totalNumberObjects = 0;
    
    private static int totalNumberObjectsDeleted = 0;
    
    public static synchronized void AddObjectsTotal(int number){
        totalNumberObjects += number;
    }
    
    public static synchronized void addObjectsDeleted(int number){
        totalNumberObjectsDeleted += number;
    }
    
}
