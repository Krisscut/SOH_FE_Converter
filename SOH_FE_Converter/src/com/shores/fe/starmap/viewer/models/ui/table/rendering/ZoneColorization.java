package com.shores.fe.starmap.viewer.models.ui.table.rendering;

//TODO

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHZoneType;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

public class ZoneColorization extends TreeTableCell<ITreeItemSOH, String> {

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            String style = "";
            //TODO : update image view depending on type
            if (!empty && item != null) {
                SOHZoneType objType = SOHZoneType.fromString(item);
                if (objType != SOHZoneType.Unknown){
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
        return (TreeTableColumn<ITreeItemSOH, String> p) -> new ZoneColorization();
    }
}