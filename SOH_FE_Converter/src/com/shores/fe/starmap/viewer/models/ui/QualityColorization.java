
package com.shores.fe.starmap.viewer.models.ui;

import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import javafx.scene.Node;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;


public final class QualityColorization extends TreeTableCell<TreeItemSOH, String> {


    @Override
    protected void updateItem(String value, boolean empty) {
        super.updateItem(value, empty);
        String text = null;
        Node graphic = null;
        String style = "";
        if (value != null && !value.equals("null")&& !empty && !value.isEmpty()) {
            text = value;
            final TreeItemSOH item = getTreeTableRow().getItem();
            
            String[] parts = text.split("\\(");
            int quality = Integer.parseInt(parts[0]);
            if (quality > 248){
                style = "-fx-text-fill: #FA0A31;";
            } else if (quality > 200) {
                style = "-fx-text-fill: #F0AE1F;";
            } else if (quality > 150) {
                style = "-fx-text-fill: #B3CC35;";
            } else if (quality > 100 ) {
                style = "-fx-text-fill: #2DE3CB;";
            } else if (quality > 50 ) {
                style = "-fx-text-fill: #274EE8;";
            } else {
                style = "-fx-text-fill: #C028DE;";
            }
        }
        style += "-fx-font-weight: bold;";
        setText(text);
        setGraphic(graphic);
        setStyle(style);
    }

    // Fabrique statique.
    public static Callback<TreeTableColumn<TreeItemSOH, String>, TreeTableCell<TreeItemSOH, String>> forTreeTableColumn() {
        return (TreeTableColumn<TreeItemSOH, String> p) -> new QualityColorization();
    }
}