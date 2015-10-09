package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Planet;
import generated.Star;
import generated.System;
import javafx.scene.control.TreeItem;

public class SystemImpl extends System implements ITreeItemSOH{
    System system = null;

    SystemImpl(System system) {
        this.system = system;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(
                system.getName()+ " (id : " + system.getSystemId()+ ")",
                SOHObjectType.System,
                "[" + system.getX() + "," + system.getY() + "," + system.getZ() + "]")); //, depIcon);
        for (Object planetOrStar : system.getPlanetOrStar()) {
            if (planetOrStar instanceof Planet) {
                treeRoot.getChildren().add(new PlanetImpl((Planet) planetOrStar).getTreeItem());
            } else if (planetOrStar instanceof Star) {
                treeRoot.getChildren().add(new StarImpl((Star)planetOrStar).getTreeItem());
            }
        }
        return treeRoot;
    }
    
}