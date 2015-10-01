package soh_fe_converter;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Administrateur
 */
public class SearchModule {
    private GridPane searchBar;

    public SearchModule() {
        //Creating a GridPane container
        searchBar = new GridPane();
        searchBar.setPadding(new Insets(10, 10, 10, 10));
        searchBar.setVgap(5);
        searchBar.setHgap(5);
        //Defining the Name text field
        final TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(10);
        name.getText();
        GridPane.setConstraints(name, 0, 0);
        searchBar.getChildren().add(name);

        //Defining the Submit button
        Button submit = new Button("Search");
        GridPane.setConstraints(submit, 1, 0);
        searchBar.getChildren().add(submit);
        
    }
    
    GridPane getSearchBar() {
        return searchBar;
    }
}
