package com.shores.fe.starmap.viewer.models.ui.table.rendering;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHAtmoType;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

public class AtmosphereColorization extends TreeTableCell<ITreeItemSOH, String> {

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            String style = "";
            //TODO : update image view depending on type
            if (!empty && item != null) {
                SOHAtmoType objType = SOHAtmoType.fromString(item);
                if (objType != SOHAtmoType.Unknown){
                    style = "-fx-text-fill: #" + objType.getColor() + ";";
                }
                setText(item);
                setStyle(style);
            } else {
                setText(null);
                setGraphic(null);
            }
            setStyle(style);
        }

    // Fabrique statique.
    public static Callback<TreeTableColumn<ITreeItemSOH, String>, TreeTableCell<ITreeItemSOH, String>> forTreeTableColumn() {
        return (TreeTableColumn<ITreeItemSOH, String> p) -> new AtmosphereColorization();
    }
}