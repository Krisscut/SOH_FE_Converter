package com.shores.fe.starmap.viewer.models.export;

public class ExportResult {
    /** Will contain for example resource type for grouping */
    String exportType = "";
    String resultExport = "";

    public ExportResult(String exportType, String resultExport) {
        this.exportType = exportType;
        this.resultExport = resultExport;
    }

    public String getExportType() {
        return exportType;
    }

    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    public String getResultExport() {
        return resultExport;
    }

    public void setResultExport(String resultExport) {
        this.resultExport = resultExport;
    }
    
    
}
