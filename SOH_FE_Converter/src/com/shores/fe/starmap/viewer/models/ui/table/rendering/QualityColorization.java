
package com.shores.fe.starmap.viewer.models.ui.table.rendering;

import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.models.ui.ColorFading;
import java.awt.Color;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.PopupControl;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import javafx.util.Callback;


public final class QualityColorization extends TreeTableCell<ITreeItemSOH, Integer> {
    private static final String DEFAULT_STYLE_CLASS = "combo-box-popup";
    private final PopupControl popup = new PopupControl();
    private double popupXlocation = 0.0;
    private double popupYlocation = 0.0;

    public QualityColorization() {
        super();
        /**
        popup.getStyleClass().add(DEFAULT_STYLE_CLASS);
        popup.setAutoHide(true);
        popup.setAutoFix(true);

        popup.setHideOnEscape(true);
        
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event)
                {
                    if (event.getButton() == MouseButton.SECONDARY){
                        popupXlocation = event.getScreenX();
                        popupYlocation = event.getScreenY();
                        popup.show(mainWindow);
                    }
                }
            });
        */
    }

    @Override
    protected void updateItem(Integer value, boolean empty) {
        super.updateItem(value, empty);
        String text = null;
        Node graphic = null;
        String style = "";
        if (value != null && !value.equals("null")&& !empty) {
            text = value.toString();
            final ITreeItemSOH item = getTreeTableRow().getItem();
            
            Color color = ColorFading.blendColors(value/258f);
            String hex = "rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
            style = "-fx-text-fill: "+hex + ";";

            /**
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
            * */
        } else {
            //style = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";
           // style += "-fx-background : linear-gradient(to bottom, rgba(245,246,246,1) 0%,rgba(219,220,226,1) 21%,rgba(184,186,198,1) 49%,rgba(221,223,227,1) 80%,rgba(245,246,246,1) 100%);";
        }
        style += "-fx-font-weight: bold;";
        setText(text);
        setGraphic(graphic);
        setStyle(style);
    }

    // Fabrique statique.
    public static Callback<TreeTableColumn<ITreeItemSOH, Integer>, TreeTableCell<ITreeItemSOH, Integer>> forTreeTableColumn() {
        return (TreeTableColumn<ITreeItemSOH, Integer> p) -> new QualityColorization();
    }
}