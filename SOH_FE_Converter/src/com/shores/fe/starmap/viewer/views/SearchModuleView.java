package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.SearchModuleController;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.observability.Observer;
import com.shores.fe.starmap.viewer.models.starmap.SOHResource;
import static java.awt.SystemColor.text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.TextAlignment;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.RangeSlider;
import org.controlsfx.control.SegmentedButton;
import static sun.swing.SwingUtilities2.submit;

public class SearchModuleView implements IView, Observer{
    private GridPane searchBar;
    private SearchModuleController controller;
    
    final TextField searchField = new TextField();
    final Button submitButton;
    final CheckComboBox resourceBox;
            
    public SearchModuleView(SearchModuleController searchModuleController) {
        this.controller = searchModuleController;
        
        //Creating a GridPane container
        searchBar = new GridPane();
        searchBar.setPadding(new Insets(10, 10, 10, 10));
        searchBar.setVgap(5);
        searchBar.setHgap(5);
        //Defining the Name text field
        
        Region spacerStart = new Region();
        GridPane.setConstraints(spacerStart, 0, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.SOMETIMES, Priority.NEVER);
        searchBar.getChildren().add(spacerStart);
        
        searchField.setPromptText("Name of galaxy, sector, system or planet here");
        searchField.setPrefColumnCount(10);
        searchField.getText();
        searchField.setMinWidth(200);
        GridPane.setConstraints(searchField, 1, 0);
        searchBar.getChildren().add(searchField);
        
        resourceBox = new CheckComboBox();
        resourceBox.getItems().addAll(SOHResource.values());
        resourceBox.setTooltip(new Tooltip("Select resources to display"));
        resourceBox.setMaxWidth(90);
        GridPane.setConstraints(resourceBox, 2, 0);
        searchBar.getChildren().add(resourceBox);
        
        ToggleButton b1 = new ToggleButton("Starmap");
        b1.setSelected(true);
        ToggleButton b2 = new ToggleButton("Galaxy");
        ToggleButton b3 = new ToggleButton("Sector");
        ToggleButton b4 = new ToggleButton("System");
        ToggleButton b5 = new ToggleButton("Planet");

        SegmentedButton segmentedButton = new SegmentedButton();    
        segmentedButton.getButtons().addAll(b1, b2, b3, b4, b5);
        segmentedButton.getStyleClass().add(SegmentedButton.STYLE_CLASS_DARK);
        segmentedButton.setDisable(true);
        GridPane.setConstraints(segmentedButton, 3, 0);
        searchBar.getChildren().add(segmentedButton);
        
        final Separator separator5 = new Separator(Orientation.VERTICAL);
        GridPane.setConstraints(separator5, 4, 0);
        searchBar.getChildren().add(separator5);
        
        final RangeSlider hSlider = new RangeSlider(0, 32, 0, 32);
        hSlider.setBlockIncrement(1);
        hSlider.setDisable(true);
        hSlider.setMinWidth(200);
        GridPane.setConstraints(hSlider, 5, 0);
        searchBar.getChildren().add(hSlider);
        
        final Separator separator6 = new Separator(Orientation.VERTICAL);
        GridPane.setConstraints(separator6, 7, 0);
        searchBar.getChildren().add(separator6);
        
        Region spacerEnd = new Region();
        GridPane.setConstraints(spacerEnd, 8, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.SOMETIMES, Priority.NEVER);
        searchBar.getChildren().add(spacerEnd);
        
        //Defining the Submit button
        submitButton= new Button();
        Label  label  = new Label("Search");
        label.setRotate(-90);
        submitButton.setGraphic(new Group(label));

        GridPane.setConstraints(submitButton, 9, 0);
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Notifications.create()
                    .title("Not implemented Yet")
                    .text("Sorry, this functionnality has not been implemented yet")
                    .showWarning();
            }
        });
        searchBar.getChildren().add(submitButton);
        
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
