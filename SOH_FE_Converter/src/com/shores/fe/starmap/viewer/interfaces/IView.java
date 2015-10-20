package com.shores.fe.starmap.viewer.interfaces;

import javafx.scene.Node;

public interface IView {
    void initUIComponents();
    void setUpComponentsLocation();
    void addEventHandler();
    
    /** Returns the view Element */
    public Node getViewElement();
}

