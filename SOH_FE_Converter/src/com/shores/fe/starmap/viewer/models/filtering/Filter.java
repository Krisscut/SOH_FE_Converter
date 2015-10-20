package com.shores.fe.starmap.viewer.models.filtering;

import com.shores.fe.starmap.viewer.models.starmap.enums.HierarchySelector;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHResource;
import java.util.ArrayList;
import java.util.List;

public class Filter {
    String name = "";
    List<SOHResource> resources = new ArrayList<>();
    HierarchySelector startAt = HierarchySelector.Starmap;
    int tlMin = 0;
    int tlMax = 32;

    public Filter() {
    }

    public Filter(String name, List<SOHResource> resourcesSelected, HierarchySelector start, int tlLow, int tlMax) {
        this.name = name;
        this.resources = resourcesSelected;
        this.startAt = start;
        this.tlMin = tlLow;
        this.tlMax = tlMax;
    }
}
