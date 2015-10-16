package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.SearchModuleController;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.interfaces.observability.Observer;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.starmap.SOHResource;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.RangeSlider;
import org.controlsfx.control.SegmentedButton;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

public class SearchModuleView implements IView, Observer{
    private GridPane searchBar;
    private SearchModuleController controller;
    
    final TextField searchField = new TextField();
    final CheckBox filterOn;
    final CheckComboBox resourceBox;
    
    ValidationSupport validationSupport = new ValidationSupport();
            
    public SearchModuleView(SearchModuleController searchModuleController) {
        this.controller = searchModuleController;
        
        //Creating a GridPane container
        searchBar = new GridPane();
        searchBar.setPadding(new Insets(10, 10, 10, 10));
        searchBar.setVgap(5);
        searchBar.setHgap(5);
        //Defining the Name text field
        
        int column = 0;
        
        Label searchBarTitle = new Label("FILTER PANEL");
        searchBarTitle.setStyle(""
        + " -fx-font-size: 20px;"
        + " -fx-text-fill: DarkGrey;");
        GridPane.setConstraints(searchBarTitle, column, 0);
        searchBar.getChildren().add(searchBarTitle);
        column ++;
        
        Region spacerStart = new Region();
        GridPane.setConstraints(spacerStart, column, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.SOMETIMES, Priority.NEVER);
        searchBar.getChildren().add(spacerStart);
        column ++;
        
        searchField.setPromptText("Name of galaxy, sector, system or planet here");
        searchField.setPrefColumnCount(10);
        searchField.getText();
        searchField.setMinWidth(200);
        GridPane.setConstraints(searchField, column, 0);
        searchBar.getChildren().add(searchField);
        column ++;
        
        resourceBox = new CheckComboBox();
        resourceBox.getItems().addAll(SOHResource.values());
        resourceBox.setTooltip(new Tooltip("Select resources to display"));
        resourceBox.setMaxWidth(90);
        GridPane.setConstraints(resourceBox, column, 0);
        searchBar.getChildren().add(resourceBox);
        column ++;
        
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
        GridPane.setConstraints(segmentedButton, column, 0);
        searchBar.getChildren().add(segmentedButton);
        column ++;
        
        final Separator separator5 = new Separator(Orientation.VERTICAL);
        GridPane.setConstraints(separator5, column, 0);
        searchBar.getChildren().add(separator5);
        column ++;
        
        TextField labelSliderLeft = new TextField("0");
        labelSliderLeft.setMaxWidth(30);
        labelSliderLeft.setDisable(false);
        GridPane.setConstraints(labelSliderLeft, column, 0);
        searchBar.getChildren().add(labelSliderLeft);
        column ++;
        
        final RangeSlider hSlider = new RangeSlider(0, 32, 0, 32);
        hSlider.setBlockIncrement(1);
        hSlider.setDisable(false);
        hSlider.setMinWidth(200);
        GridPane.setConstraints(hSlider, column, 0);
        searchBar.getChildren().add(hSlider);
        column ++;
        
        TextField labelSliderRight = new TextField("32");
        labelSliderRight.setMaxWidth(30);
        labelSliderRight.setDisable(false);
        GridPane.setConstraints(labelSliderRight, column, 0);
        searchBar.getChildren().add(labelSliderRight);
        column ++;
        
        
        //TODO : refactor
        labelSliderLeft.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                double minSliderValue = hSlider.getLowValue();
                if (s2.isEmpty() || s2.equals("-")) return;
                if (Integer.parseInt(s2) > 32){
                    labelSliderLeft.setText("32");
                }
                if (Integer.parseInt(s2) > Integer.parseInt(labelSliderRight.getText())){
                    labelSliderLeft.setText((labelSliderRight.getText()));
                }
                if (s2.equals(Integer.parseInt(String.format("%.0f", minSliderValue)))){
                    System.out.println("Same value as slider, do nothing");
                } else {
                    hSlider.setLowValue(Double.parseDouble(s2));
                }
            }
        });
        validationSupport.registerValidator(labelSliderLeft, Validator.createEmptyValidator("Number is required"));
        validationSupport.registerValidator(labelSliderLeft, (Control c, String newValue) -> 
            ValidationResult.fromErrorIf( labelSliderLeft, "Low value value should be >= 0",  
                    !newValue.isEmpty() && !newValue.equals("-") && (Integer.parseInt(newValue) < 0) ));
        

        labelSliderRight.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                double maxSliderValue = hSlider.getHighValue();
                if (s2.isEmpty() || s2.equals("-")) return;
                if (s2.equals(Integer.parseInt(String.format("%.0f", maxSliderValue)))){
                    System.out.println("Same value as slider, do nothing");
                } else {
                    hSlider.setHighValue(Double.parseDouble(s2));
                }
            }
        });
        validationSupport.registerValidator(labelSliderRight, Validator.createEmptyValidator("Number is required"));
        validationSupport.registerValidator(labelSliderRight, (Control c, String newValue) -> 
        ValidationResult.fromErrorIf(labelSliderRight, "Low value value should be >= 0",  
                    !newValue.isEmpty() && !newValue.equals("-") && (Integer.parseInt(newValue) < 0) ));
 
        validationSupport.registerValidator(labelSliderRight, Validator.createEmptyValidator("Number is required"));
        
        
        final Separator separator6 = new Separator(Orientation.VERTICAL);
        GridPane.setConstraints(separator6, column, 0);
        searchBar.getChildren().add(separator6);
        column ++;
        
        Region spacerEnd = new Region();
        GridPane.setConstraints(spacerEnd, column, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.SOMETIMES, Priority.NEVER);
        searchBar.getChildren().add(spacerEnd);
        column ++;
        
        //Defining the Submit button
        filterOn = new CheckBox();
        Label  label  = new Label("Activated");
        label.setStyle(""
        + " -fx-font-size: 20px;"
        + " -fx-text-fill: DarkGrey;");
        //label.setRotate(-90);
        filterOn.setGraphic(new Group(label));
        filterOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Notifications.create()
                    .title("Not implemented Yet")
                    .text("Sorry, this functionnality has not been implemented yet")
                    .showWarning();
            }
        });
        GridPane.setConstraints(filterOn, column, 0);
        searchBar.getChildren().add(filterOn);
        column ++;
        
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
