package com.shores.fe.starmap.viewer.interfaces;

import javafx.scene.Node;

public interface IView {
    /**
     * Components initialization, name, size, style ...
     */
    void initUIComponents();
    
    /**
     * Components location is set
     */
    void setUpComponentsLocation();
    
    /**
     * Adds all the bindings and the events handlers
     */
    void addEventHandler();
    
    /** Returns the view Element */
    public Node getViewElement();
}

