package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.SearchModuleController;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.observability.Observer;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SearchModuleView implements IView, Observer{
    private GridPane searchBar;

    public SearchModuleView(SearchModuleController searchModuleController) {
        //Creating a GridPane container
        searchBar = new GridPane();
        searchBar.setPadding(new Insets(10, 10, 10, 10));
        searchBar.setVgap(5);
        searchBar.setHgap(5);
        //Defining the Name text field
        final TextField name = new TextField();
        name.setPromptText("Enter the search key here");
        name.setPrefColumnCount(10);
        name.getText();
        GridPane.setConstraints(name, 0, 0);
        searchBar.getChildren().add(name);

        //Defining the Submit button
        Button submit = new Button("Search");
        GridPane.setConstraints(submit, 1, 0);
        searchBar.getChildren().add(submit);
    }

    @Override
    public Node getViewElement() {
       return searchBar;
    }

    @Override
    public void update(FeedbackCode code) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
