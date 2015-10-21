package com.shores.fe.starmap.viewer.models.filtering;

import com.shores.fe.starmap.viewer.models.starmap.enums.HierarchySelector;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filter {
    String name = "";
    List<SOHResource> resources = new ArrayList<>();
    HierarchySelector startAt = HierarchySelector.Starmap;
    int tlMin = 0;
    int tlMax = 32;

    public Filter() {
    }

    public Filter(String searchFieldText, List<SOHResource> resourcesSelected, HierarchySelector start, int tlLow, int tlMax) {
        this.name = name;
        this.resources = resourcesSelected;
        this.startAt = start;
        this.tlMin = tlLow;
        this.tlMax = tlMax;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filter other = (Filter) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.resources, other.resources)) {
            return false;
        }
        if (this.startAt != other.startAt) {
            return false;
        }
        if (this.tlMin != other.tlMin) {
            return false;
        }
        if (this.tlMax != other.tlMax) {
            return false;
        }
        return true;
    }
    
    
    public boolean compareTo(Filter filter){
        return false;
    }
            
            
    /**
     * Returns true if the given filter is more restrictive than the current filter ... ( can speed up the process of research by using and existing tree instead of building a new one.
     */
    public boolean isMoreRestrictive(Filter filter){
        return false;
    }
}
