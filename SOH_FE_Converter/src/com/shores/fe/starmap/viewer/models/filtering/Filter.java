package com.shores.fe.starmap.viewer.models.filtering;

import com.shores.fe.starmap.viewer.models.starmap.HierarchySelector;
import com.shores.fe.starmap.viewer.models.starmap.SOHResource;
import java.util.ArrayList;
import java.util.List;

public class Filter {
    String name = "";
    List<SOHResource> resources = new ArrayList<>();
    HierarchySelector startAt = HierarchySelector.Starmap;
    int tlMin = 0;
    int tlMax = 32;
}
