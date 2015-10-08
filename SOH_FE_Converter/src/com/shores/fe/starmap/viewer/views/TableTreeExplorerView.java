package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.TableTreeExplorerController;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.observability.Observer;
import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;
import java.awt.Color;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.paint.Paint;

public class TableTreeExplorerView implements IView, Observer{
        /*
    private final ImageView depIcon = new ImageView (
            new Image(getClass().getResourceAsStream("department.png"))
    );
    */
    
    TreeTableView<TreeItemSOH> treeTableView;
    private TableTreeExplorerController controller = null;

    public TableTreeExplorerView(TableTreeExplorerController tableTreeExplorerController) {
        controller = tableTreeExplorerController;
        /** 
         *  TREE VIEW START
         */
        /**
        employees.stream().forEach((employee) -> {
            root.getChildren().add(new TreeItem<>(employee));
        });
        */

        TreeTableColumn<TreeItemSOH, String> objectColumn = new TreeTableColumn<>("Object");
        objectColumn.setPrefWidth(200);
        objectColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<TreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getName())
        );
        
        TreeTableColumn<TreeItemSOH, String> typeColumn = new TreeTableColumn<>("Type");
        typeColumn.setPrefWidth(60);
        typeColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<TreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getType())
        );
        
        /** 
         * TEST AUTO COLORIZATION
         */
        
        // Custom rendering of the table cell.
        /**
        typeColumn.setCellFactory(column -> {
            return new TreeTableCell<TreeItemSOH, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        setText(item);
                        // Style all dates in March with a different color.
                        if (item.equals(SOHObjectType.Sector.name())) {
                            setStyle("-fx-background-color: yellow; -fx-text-fill: rgb(49, 0, 23);");
                        } else if (item.equals(SOHObjectType.Galaxy.name())) {
                            setStyle("-fx-background-color: red ; -fx-text-fill: rgb(49, 255, 23);");
                        } else if (item.equals(SOHObjectType.Starmap.name())) {
                            setStyle("-fx-background-color: green ; -fx-text-fill: rgb(49, 0, 255);");
                        } else {
                            setStyle("");
                        }
                    }
                }
            };
        });
        * */
        

        TreeTableColumn<TreeItemSOH, String> coordinatesColumn = new TreeTableColumn<>("Coordinates");
        coordinatesColumn.setPrefWidth(100);
        coordinatesColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<TreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getCoordinates())
        );

        treeTableView = new TreeTableView<>();
        treeTableView.getColumns().setAll(objectColumn, typeColumn, coordinatesColumn);
        treeTableView.setTableMenuButtonVisible(true);
        
        //Multiple row selection
        treeTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        treeTableView.getSelectionModel().setCellSelectionEnabled(false);

        //Selection changed
        treeTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            tableTreeExplorerController.treeSelectionChanged(treeTableView.getSelectionModel().getSelectedItems());
        });
    }
    
    @Override
    public Node getViewElement() {
        return treeTableView;
    }


    
    void setNewTableContent(){
        treeTableView.setRoot(controller.getModel().getTreeRoot());
    }

    @Override
    public void update(FeedbackCode code) {
        setNewTableContent();
    }
    
}
