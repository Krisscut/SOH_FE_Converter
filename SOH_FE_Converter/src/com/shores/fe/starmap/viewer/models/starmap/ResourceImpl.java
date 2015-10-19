package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.export.ExportResult;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHObjectType;
import com.shores.fe.starmap.viewer.utils.QualityUtils;
import generated.Resource;
import javafx.scene.control.TreeItem;

public class ResourceImpl extends TreeItemSOH implements ITreeItemSOH{
    /** Parent */ 
    ITreeItemSOH parent;
    /** Data holder */
    Resource resource;
    
    ResourceImpl(ITreeItemSOH parent, Resource resource) {
        this.parent = parent;
        this.resource = resource;
    }

    @Override
    public TreeItem<ITreeItemSOH> getTreeItem() {
        return new TreeItem<>(this);
    }
    
    @Override
    public String getName() {
        return resource.getName();
    }

    @Override
    public SOHObjectType getType() {
        return SOHObjectType.Resource;
    }

    @Override
    public Integer getQualityZone1() {
        if (resource.getQualityZone1() == null && resource.getQualityZone2() == null && resource.getQualityZone3() == null && resource.getQuality() != null)
            return DEFAULT_VALUE_INTEGER;
        else
            if (resource.getQualityZone1() != null) return ((Number) resource.getQualityZone1()).intValue();
            else {
                return null;
            }
    }

    @Override
    public Integer getQualityZone2() {
        if (resource.getQualityZone1() == null && resource.getQualityZone2() == null && resource.getQualityZone3() == null && resource.getQuality() != null)
            return DEFAULT_VALUE_INTEGER;
        else
            if (resource.getQualityZone2() != null) return ((Number) resource.getQualityZone2()).intValue();
            else {
                return null;
            }
    }
    
    @Override
    public Integer getQualityZone3() {
        if (resource.getQualityZone1() == null && resource.getQualityZone2() == null && resource.getQualityZone3() == null && resource.getQuality() != null)
            return DEFAULT_VALUE_INTEGER;
        else
            if (resource.getQualityZone3() != null) return ((Number) resource.getQualityZone3()).intValue();
            else {
                return null;
            }
    }
    
/** 
 [*color=#009900*]System UJRHZ - nomSecteur (160,6,-1)[/color] - Q238 - Tl31 [*color=#FF0000*]Planete : Alpha/Beta/Gamma IVX (inferno) [/color] (habitable dans système) :*cross*: ou :*check*:
 */
    
    @Override
    public ExportResult getExportBBCode() {
        String bbCodeGenerated = "";
        String systemName = "";
        String numberPlanet = "";
        String zonePlanet = "";
        String isHabitableSystem = "";
        String zone = "";
        String sectorName = "";
        String sectorCoordinates = "";
        String cross = ":cross:";

        if (parent instanceof AtmosphereImpl || parent instanceof BiosphereImpl || parent instanceof GeosphereImpl || parent instanceof HydrosphereImpl) {
            PlanetImpl planet = (PlanetImpl) parent.getParent();
            numberPlanet = planet.getName();
            zonePlanet = planet.getZone().toString();
            
            SystemImpl systemTmp = (SystemImpl) planet.getParent();
            systemName = systemTmp.getName();
            isHabitableSystem = ((SystemImpl) planet.getParent()).searchForHabitableInSystem() == true ? "Habitable in system" : "No habitable in system";
            SectorImpl sectorTmp = (SectorImpl) systemTmp.getParent();
            sectorName = sectorTmp.getName();
            sectorCoordinates = sectorTmp.getCoordinates();
        }
        if (parent instanceof StarImpl) {
            //TODO
        }
        Integer[] qualities = getQualities();
        int bestQualityInt = QualityUtils.GetBestQualityInt(qualities);
        String bestQualityZone = QualityUtils.GetBestQualityZone(qualities);
        int bestQualityTL = QualityUtils.QualityToTechLevel(bestQualityInt);
        
        bbCodeGenerated += "[color=#009900] System " + systemName + " - " + sectorName + " " + sectorCoordinates + "[/color] - Q" + QualityUtils.GetBestQualityInt(qualities)+ " - Tl "+ bestQualityTL +" [color=#FF0000]Planete : " + numberPlanet + "  "+ bestQualityZone + " (" + zonePlanet + ")  [/color] " +  isHabitableSystem + " " + cross;
        
        return new ExportResult(getName(), bbCodeGenerated);
    }

    @Override
    public ITreeItemSOH getParent() {
        return parent;    /** Starmap is the root node */
    }

    @Override
    public boolean isValidData() {
        return true;    // leaf node, always valid
    }
    
    private Integer[] getQualities(){
        return new Integer[] { getQualityZone1(), getQualityZone2(), getQualityZone3() };
    }
}