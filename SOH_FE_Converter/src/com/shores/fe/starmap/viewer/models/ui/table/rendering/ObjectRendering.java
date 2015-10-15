
package com.shores.fe.starmap.viewer.models.ui.table.rendering;

import com.shores.fe.starmap.viewer.controllers.TableTreeExplorerController;
import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.ImageView;
import javafx.util.Callback;


public final class ObjectRendering extends TreeTableCell<ITreeItemSOH, String> {
        private ImageView imageView;

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            //TODO : update image view depending on type
            if (!empty && item != null) {
                if (imageView == null) {
                    imageView = new ImageView(TableTreeExplorerController.getInstance().getCore().depimg);
                    imageView.setFitWidth(16);
                    imageView.setPreserveRatio(true);
                    imageView.setSmooth(true);
                    imageView.setCache(true);
                }

                setText(item);
                setGraphic(imageView);
            } else {
                setText(null);
                setGraphic(null);
            }
        }

    // Fabrique statique.
    public static Callback<TreeTableColumn<ITreeItemSOH, String>, TreeTableCell<ITreeItemSOH, String>> forTreeTableColumn() {
        return (TreeTableColumn<ITreeItemSOH, String> p) -> new ObjectRendering();
    }
}