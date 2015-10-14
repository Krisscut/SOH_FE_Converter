package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.SearchModuleController;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.observability.Observer;
import com.shores.fe.starmap.viewer.utils.DialogUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SearchModuleView implements IView, Observer{
    private GridPane searchBar;
    private SearchModuleController controller;

    public SearchModuleView(SearchModuleController searchModuleController) {
        this.controller = searchModuleController;
        
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
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DialogUtils.notImplementedYetDialog();
            }
        });

        searchBar.getChildren().add(submit);
        
        searchBar.setStyle("-fx-background-color: #336699;");
    }

    @Override
    public Node getViewElement() {
       return searchBar;
    }

    private void updateVisibility() {
        if (controller.getModel().isShowViewSearch()) {
           this.controller.getCore().getVbox().getChildren().add(0,this.searchBar);
        }
        else {
           this.controller.getCore().getVbox().getChildren().remove(this.searchBar);
            
        }
    }
    
    @Override
    public void update(FeedbackCode code) {
        switch(code) {
            case REFRESH_ALL:
            case MAIN_DATA_CHANGED:
            case BBCODE_GENERATED:
                break;
            case SEARCH_VIEW_CHANGED:
                updateVisibility();
        } 
    }
    
}
