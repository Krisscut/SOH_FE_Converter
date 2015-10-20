package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.interfaces.IView;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.paint.Color;
import org.controlsfx.glyphfont.FontAwesome;

public class ToolbarView implements IView{
    ToolBar toolbar;
    
    FontAwesome fontAwesome = new FontAwesome();
    static ToolbarView instance;

    private ToolbarView() {
        toolbar = new ToolBar(
            new Button("New", fontAwesome.create(FontAwesome.Glyph.CROSSHAIRS).size(16).color(Color.DARKBLUE)),
            new Button("Open", fontAwesome.create(FontAwesome.Glyph.FOLDER_OPEN_ALT).size(16).color(Color.DARKBLUE)),
            new Button("Clear", fontAwesome.create(FontAwesome.Glyph.ERASER).size(16).color(Color.RED)),
            new Separator(Orientation.VERTICAL),
            new Button("Save Filter", fontAwesome.create(FontAwesome.Glyph.SAVE).size(16).color(Color.YELLOW)),
            new Button("Save Filter as ...", fontAwesome.create(FontAwesome.Glyph.FOLDER).size(16).color(Color.YELLOWGREEN)),   
            new Button("Load Filter", fontAwesome.create(FontAwesome.Glyph.FOLDER_OPEN).size(16).color(Color.RED)),
            new Separator(Orientation.VERTICAL),
            new Button("Website", fontAwesome.create(FontAwesome.Glyph.HOME).size(16).color(Color.DARKBLUE)),
            new Button("Feedback", fontAwesome.create(FontAwesome.Glyph.BUG).size(16).color(Color.DARKBLUE)),
            new Button("Trello", fontAwesome.create(FontAwesome.Glyph.TRELLO).size(16).color(Color.DARKCYAN)),
            new Button("Github", fontAwesome.create(FontAwesome.Glyph.GITHUB).size(16).color(Color.DARKBLUE))
        );
    }
    
    public static ToolbarView getInstance(){
        if (instance == null){
            instance = new ToolbarView();
        }
        return instance;
    }
    
    @Override
    public Node getViewElement() {
        return toolbar;
    }

    @Override
    public void initUIComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUpComponentsLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEventHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
