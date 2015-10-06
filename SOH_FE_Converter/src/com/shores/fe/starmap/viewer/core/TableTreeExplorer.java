package com.shores.fe.starmap.viewer.core;

import java.util.Arrays;
import java.util.List;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import com.shores.fe.starmap.viewer.models.Employee;
import com.shores.fe.starmap.viewer.models.Galaxy;
import com.shores.fe.starmap.viewer.models.Universe;

/**
 *
 * @author Administrateur
 */
public class TableTreeExplorer {
    List<Employee> bodies = Arrays.<Employee>asList(
        new Employee("Ethan Williams", "ethan.williams@example.com"),
        new Employee("Emma Jones", "emma.jones@example.com"),
        new Employee("Michael Brown", "michael.brown@example.com"),
        new Employee("Anna Black", "anna.black@example.com"),
        new Employee("Rodger York", "roger.york@example.com"),
        new Employee("Susan Collins", "susan.collins@example.com"));
    
    /*
    private final ImageView depIcon = new ImageView (
            new Image(getClass().getResourceAsStream("department.png"))
    );
    */

    final TreeItem<Employee> root = 
        new TreeItem<>(new Employee("Sales Department", "")); //, depIcon);
    
    TreeTableView<Employee> treeTableView;

    public TableTreeExplorer() {
        
        /** 
         *  TREE VIEW START
         */
        /**
        employees.stream().forEach((employee) -> {
            root.getChildren().add(new TreeItem<>(employee));
        });
        */

        TreeTableColumn<Employee, String> empColumn = 
            new TreeTableColumn<>("Object");
        empColumn.setPrefWidth(150);
        empColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<Employee, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getName())
        );

        TreeTableColumn<Employee, String> emailColumn = 
            new TreeTableColumn<>("Coordinates");
        emailColumn.setPrefWidth(190);
        emailColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<Employee, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getEmail())
        );

        treeTableView = new TreeTableView<>();
        treeTableView.getColumns().setAll(empColumn, emailColumn);
        treeTableView.setTableMenuButtonVisible(true);
    }
    
    TreeTableView<Employee> getTableTreeComponent(){
        return treeTableView;
    }
    
    void setNewTableContent(Universe universe){
        TreeItem<Employee> root = new TreeItem<>(new Employee(universe.getName(), "")); //, depIcon);
        
        for(Galaxy galaxy : universe.galaxies){
            root.getChildren().add(new TreeItem<>(new Employee(galaxy.getName(), "")));
        }
        
                /**
        employees.stream().forEach((employee) -> {
            root.getChildren().add(new TreeItem<>(employee));
        });
        */
        treeTableView.setRoot(root);
    }
    
}
