package com.shores.fe.starmap.viewer.models.starmap;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import generated.Star;
import javafx.scene.control.TreeItem;

public class StarImpl extends Star implements ITreeItemSOH{
    Star star = null;
    StarImpl(Star star) {
        this.star = star;
    }

    @Override
    public TreeItem<TreeItemSOH> getTreeItem() {
        TreeItem<TreeItemSOH> treeRoot = new TreeItem<>(new TreeItemSOH(
                star.getName()+ " (id : " + star.getStarId()+ ")",
                SOHObjectType.Star,
                " ")); //, depIcon);
        
        treeRoot.getChildren().add(new ResourceImpl(star.getResource()).getTreeItem());
        
        return treeRoot;
    }
    
}
