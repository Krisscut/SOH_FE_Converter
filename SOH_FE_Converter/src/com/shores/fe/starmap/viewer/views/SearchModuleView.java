package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.SearchModuleController;
import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.interfaces.observability.Observer;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.starmap.enums.SOHResource;
import java.util.concurrent.Callable;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.RangeSlider;
import org.controlsfx.control.SegmentedButton;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.validation.ValidationSupport;

public class SearchModuleView implements IView, Observer{
    //Controller
    SearchModuleController controller;
    
    //Layout
    GridPane searchBar;

    //UI components
    Button searchBarTitle;
    TextField searchField = new TextField();
    CheckComboBox resourceBox;
    ToggleButton b1, b2, b3, b4, b5;
    SegmentedButton segmentedButton;
    TextField labelSliderLeft, labelSliderRight;
    RangeSlider hSlider;
    CheckBox filterOn;
    Button refresh;
    
    //Other vars
    ValidationSupport validationSupport = new ValidationSupport();
    final String DEFAULT_COLOR = "#336699";
    final String ACTIVE_COLOR = "#D44444";
    
    //FillTransition fillTransition = new FillTransition();
    
    ObjectProperty<Color> color;
    StringBinding cssColorSpec;
    Timeline timeline;
    
    FontAwesome fontAwesome = new FontAwesome();
            
    public SearchModuleView(SearchModuleController searchModuleController) {
        this.controller = searchModuleController;
        
        initUIComponents();
        setUpComponentsLocation();
        addEventHandler();
    }

    @Override
    public Node getViewElement() {
       return searchBar;
    }

    @Override
    public void initUIComponents() {
        //Creating a GridPane container
        searchBar = new GridPane();
        searchBar.setPadding(new Insets(10, 10, 10, 10));
        searchBar.setVgap(5);
        searchBar.setHgap(5);
        
        searchBarTitle = new Button("FILTER PANEL", fontAwesome.create(FontAwesome.Glyph.FILTER).size(24).color(Color.web(DEFAULT_COLOR)));
        
        searchBarTitle.setStyle(""
        + " -fx-font-size: 20px;"
        + " -fx-text-fill: DarkGrey;"
        + "-fx-font-weight: bold;");
        
        searchField.setPromptText("Name of galaxy, sector, system or planet here");
        searchField.setPrefColumnCount(10);
        searchField.getText();
        searchField.setMinWidth(200);
        searchField.setDisable(true);
        
        //TODO
        TextFields.bindAutoCompletion(
            searchField,
            "Hey", "Hello", "Hello World", "Apple", "Cool", "Costa", "Cola", "Coca Cola");
        
        resourceBox = new CheckComboBox();
        resourceBox.getItems().addAll(SOHResource.values());
        resourceBox.setTooltip(new Tooltip("Select resources to display"));
        resourceBox.setMaxWidth(90);
        resourceBox.setDisable(true);
        
        b1 = new ToggleButton("Starmap");
        b1.setSelected(true);
        b2 = new ToggleButton("Galaxy");
        b3 = new ToggleButton("Sector");
        b4 = new ToggleButton("System");
        b5 = new ToggleButton("Planet");

        segmentedButton = new SegmentedButton();    
        segmentedButton.getButtons().addAll(b1, b2, b3, b4, b5);
        segmentedButton.getStyleClass().add(SegmentedButton.STYLE_CLASS_DARK);
        
        labelSliderLeft = new TextField("0");
        labelSliderLeft.setMaxWidth(30);
        
        hSlider = new RangeSlider(0, 32, 0, 32);
        hSlider.setBlockIncrement(1);
        hSlider.setMinWidth(200);
        
        labelSliderRight = new TextField("32");
        labelSliderRight.setMaxWidth(30);
        
        //Defining the Submit button
        filterOn = new CheckBox();
        filterOn.setTooltip(new Tooltip("Enable or disable the filtering"));
        
        refresh = new Button("", fontAwesome.create(FontAwesome.Glyph.REFRESH).size(16).color(Color.web(DEFAULT_COLOR)));
        refresh.maxWidth(20);
        refresh.setTooltip(new Tooltip("Refresh the currently used filter."));
        
        //label.setRotate(-90);

        //Transtion
        /*
        fillTransition.set(searchBar);
        fillTransition.setDuration(new Duration(2000));
        fillTransition.setFromValue(new Color(51,102,153));
        fillTransition.setToValue(Color.GOLD);
        fillTransition.setCycleCount(value);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
        */        
        searchBar.setStyle("-fx-background-color: "+ DEFAULT_COLOR +";");
        
        color = new SimpleObjectProperty<Color>(Color.web(DEFAULT_COLOR));
                timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(color, Color.web(DEFAULT_COLOR))),
            new KeyFrame(Duration.seconds(1), new KeyValue(color, Color.web(ACTIVE_COLOR))));
    }

    @Override
    public void setUpComponentsLocation() {
        int column = 0;
        
        GridPane.setConstraints(searchBarTitle, column, 0);
        searchBar.getChildren().add(searchBarTitle);
        column ++;
        
        Region spacerStart = new Region();
        GridPane.setConstraints(spacerStart, column, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.SOMETIMES, Priority.NEVER);
        searchBar.getChildren().add(spacerStart);
        column ++;
        
        GridPane.setConstraints(searchField, column, 0);
        searchBar.getChildren().add(searchField);
        column ++;
        
        GridPane.setConstraints(resourceBox, column, 0);
        searchBar.getChildren().add(resourceBox);
        column ++;
        
        GridPane.setConstraints(segmentedButton, column, 0);
        searchBar.getChildren().add(segmentedButton);
        column ++;
        
        final Separator separator5 = new Separator(Orientation.VERTICAL);
        GridPane.setConstraints(separator5, column, 0);
        searchBar.getChildren().add(separator5);
        column ++;
        
        GridPane.setConstraints(labelSliderLeft, column, 0);
        searchBar.getChildren().add(labelSliderLeft);
        column ++;
        
        GridPane.setConstraints(hSlider, column, 0);
        searchBar.getChildren().add(hSlider);
        column ++;
        
        GridPane.setConstraints(labelSliderRight, column, 0);
        searchBar.getChildren().add(labelSliderRight);
        column ++;
        
        final Separator separator6 = new Separator(Orientation.VERTICAL);
        GridPane.setConstraints(separator6, column, 0);
        searchBar.getChildren().add(separator6);
        column ++;
        
        Region spacerEnd = new Region();
        GridPane.setConstraints(spacerEnd, column, 0, 1, 1, HPos.LEFT, VPos.TOP, Priority.SOMETIMES, Priority.NEVER);
        searchBar.getChildren().add(spacerEnd);
        column ++;
        
        GridPane.setConstraints(refresh, column, 0);
        searchBar.getChildren().add(refresh);
        column ++;
        
        GridPane.setConstraints(filterOn, column, 0);
        searchBar.getChildren().add(filterOn);
        column ++;
    }

    @Override
    public void addEventHandler() {
        searchBarTitle.setOnAction(HandleFilterPanelButton());
        searchField.setOnAction(evt -> HandleFilterModification(evt));
        resourceBox.getCheckModel().getCheckedItems().addListener(HandleResourceModification());
        
        b1.setOnAction(evt -> HandleFilterModification(evt));
        b2.setOnAction(evt -> HandleFilterModification(evt));
        b3.setOnAction(evt -> HandleFilterModification(evt));
        b4.setOnAction(evt -> HandleFilterModification(evt));
        b5.setOnAction(evt -> HandleFilterModification(evt));
        
        hSlider.setOnMouseExited(OnAnotherAction());
        hSlider.setOnMouseReleased(OnMouseReleasedSlider());
        
        //TODO : refactor
        labelSliderLeft.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                double minSliderValue = hSlider.getLowValue();
                if (s2.isEmpty() || s2.equals("-")) return;
                System.out.println(s2);
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
        /*
        validationSupport.registerValidator(labelSliderLeft, Validator.createEmptyValidator("Number is required"));
        validationSupport.registerValidator(labelSliderLeft, (Control c, String newValue) -> 
            ValidationResult.fromErrorIf( labelSliderLeft, "Low value value should be >= 0",  
                    !newValue.isEmpty() && !newValue.equals("-") && (Integer.parseInt(newValue) < 0) ));
        */
        

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
        /*
        validationSupport.registerValidator(labelSliderRight, Validator.createEmptyValidator("Number is required"));
        validationSupport.registerValidator(labelSliderRight, (Control c, String newValue) -> 
        ValidationResult.fromErrorIf(labelSliderRight, "Low value value should be >= 0",  
                    !newValue.isEmpty() && !newValue.equals("-") && (Integer.parseInt(newValue) < 0) ));
 
        validationSupport.registerValidator(labelSliderRight, Validator.createEmptyValidator("Number is required"));
        * */
        

        hSlider.highValueProperty().addListener(new ChangeListener<Number>(){ 
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number s, Number s2) {
                System.out.println(s2);
                labelSliderRight.setText(s2.toString());
            }
        });
        
        filterOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                enableFilterBar(filterOn.isSelected());
            }
        });
        
        refresh.setOnAction(RefreshFilterEventHandler());
        
        //Transition
        cssColorSpec = Bindings.createStringBinding(new Callable<String>() {
                            @Override
                            public String call() throws Exception {
                                return String.format("-fx-background-color: rgb(%d, %d, %d);", 
                                        (int) (256*color.get().getRed()), 
                                        (int) (256*color.get().getGreen()), 
                                        (int) (256*color.get().getBlue()));
                            }
                        }, color);
        
        searchBar.styleProperty().bind(cssColorSpec);
        
        BooleanProperty isSearchDisabled = controller.getModel().getIsSearchDisabled();
        searchBarTitle.disableProperty().bind(isSearchDisabled);
        searchField.disableProperty().bind(isSearchDisabled);
        resourceBox.disableProperty().bind(isSearchDisabled);
        segmentedButton.disableProperty().bind(isSearchDisabled);
        labelSliderLeft.disableProperty().bind(isSearchDisabled);
        hSlider.disableProperty().bind(isSearchDisabled);
        labelSliderRight.disableProperty().bind(isSearchDisabled);
        refresh.disableProperty().bind(isSearchDisabled);
    }
    
    private void updateVisibility() {
        if (controller.getModel().isShowViewSearch().get()) {
           SOH_FE_Converter.coreView.getVbox().getChildren().add(0,this.searchBar);
        }
        else {
           SOH_FE_Converter.coreView.getVbox().getChildren().remove(this.searchBar);
            
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

    private void HandleFilterModification(ActionEvent event) {
        System.out.println("TEST EVENT HANDLER " + event.toString());
    }

    private EventHandler<? super MouseEvent> OnAnotherAction() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("TEST MOUSE EVENT HANDLER " + event.toString());
            }
        };
    }

    private ListChangeListener<String> HandleResourceModification() {
        return new ListChangeListener<String>() {
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                System.out.println(resourceBox.getCheckModel().getCheckedItems());
            }
        };
    };
    
    private void enableFilterBar(boolean activated){
        /*
            String color = filterOn.isSelected() ? ACTIVE_COLOR : DEFAULT_COLOR;
            searchBar.setStyle("-fx-background-color: "+ color +";");
        */
        Notifications.create()
            .title("Not implemented Yet")
            .text("Sorry, this functionnality has not been implemented yet")
            .showWarning();
        timeline.setRate(activated ? 1 : -1);
        timeline.play();
        
        controller.getModel().getIsSearchDisabled().set(!activated);
        /*
        searchField.setDisable(!activated);
        resourceBox.setDisable(!activated);
        segmentedButton.setDisable(!activated);
        labelSliderLeft.setEditable(!activated);
        labelSliderRight.setDisable(!activated);
        hSlider.setDisable(!activated);
                */
        
        //Launch gradient tasking for the UI color
    }

    private EventHandler<ActionEvent> HandleFilterPanelButton() {
        return new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("CLICK FILTER PANEL");
            }
        };
    }

    private EventHandler<? super MouseEvent> OnMouseReleasedSlider() {
        return new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouse released slider");
            }
        };
    }

    private EventHandler<ActionEvent> RefreshFilterEventHandler() {
        return new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                controller.refreshFilter(searchField.getText(), resourceBox.getCheckModel().getCheckedItems(), segmentedButton.getToggleGroup().getSelectedToggle(), labelSliderLeft.getText(), labelSliderRight.getText());
            }
        };
    }
}
