
package com.shores.fe.starmap.viewer.models.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public abstract class ButtonUtils {

    public static Button generateButton(String name){
        Button tmpButton = new Button(name);
        
        //Image imageOk = new Image(getClass().getResourceAsStream("ok.png"));s
        DropShadow shadow = new DropShadow();
        //Adding the shadow when the mouse cursor is on
        tmpButton.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    tmpButton.setEffect(shadow);
                }
        });
        //Removing the shadow when the mouse cursor is off
        tmpButton.addEventHandler(MouseEvent.MOUSE_EXITED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    tmpButton.setEffect(null);
                }
        });
        
        tmpButton.setStyle("-fx-font: 18 arial; -fx-base:#90C3D4;");
        
        return tmpButton;
    } 
    
    
}
