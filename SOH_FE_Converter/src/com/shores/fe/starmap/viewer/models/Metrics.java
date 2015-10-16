package com.shores.fe.starmap.viewer.models;

public class Metrics {
    private static int totalNumberObjects = 0;
    
    private static int totalNumberObjectsDeleted = 0;
    
    private static int lastExportCounter = 0;
    
    public static synchronized void AddObjectsTotal(int number){
        totalNumberObjects += number;
    }
    
    public static synchronized void AddObjectsDeleted(int number){
        totalNumberObjectsDeleted += number;
    }
    
    public static synchronized void SetExportCounter(int number){
        lastExportCounter = number;
    }
    
    public static synchronized int GetExportCounter(){
        return lastExportCounter;
    }
    
}
