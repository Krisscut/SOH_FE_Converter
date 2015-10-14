package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.TableTreeExplorerController;
import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.TreeItemSOH;
import com.shores.fe.starmap.viewer.models.observability.Observer;
import com.shores.fe.starmap.viewer.models.starmap.SOHObjectType;
import com.shores.fe.starmap.viewer.models.ui.QualityColorization;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class TableTreeExplorerView implements IView, Observer{
        /*
    private final ImageView depIcon = new ImageView (
            new Image(getClass().getResourceAsStream("department.png"))
    );
    */
    
    TreeTableView<ITreeItemSOH> treeTableView;
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

        TreeTableColumn<ITreeItemSOH, String> objectColumn = new TreeTableColumn<>("Object");
        objectColumn.setPrefWidth(300);
        objectColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<ITreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getName())
        );
        
        TreeTableColumn<ITreeItemSOH, String> typeColumn = new TreeTableColumn<>("Type");
        typeColumn.setPrefWidth(60);
        typeColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<ITreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getType().name())
        );

        TreeTableColumn<ITreeItemSOH, String> coordinatesColumn = new TreeTableColumn<>("Coordinates");
        coordinatesColumn.setPrefWidth(100);
        coordinatesColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<ITreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getCoordinates())
        );
        
        TreeTableColumn<ITreeItemSOH, String> zoneColumn = new TreeTableColumn<>("Zone");
        zoneColumn.setPrefWidth(70);
        zoneColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<ITreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getZone())
        );
        
        TreeTableColumn<ITreeItemSOH, String> qualityZone1Column = new TreeTableColumn<>("Quality Zone 1");
        qualityZone1Column.setPrefWidth(70);
        qualityZone1Column.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<ITreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getQualityZone1())
        );
        
        TreeTableColumn<ITreeItemSOH, String> qualityZone2Column = new TreeTableColumn<>("Quality Zone 2");
        qualityZone2Column.setPrefWidth(70);
        qualityZone2Column.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<ITreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getQualityZone2())
        );
        
        TreeTableColumn<ITreeItemSOH, String> qualityZone3Column = new TreeTableColumn<>("Quality Zone 3");
        qualityZone3Column.setPrefWidth(70);
        qualityZone3Column.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<ITreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getQualityZone3())
        );
        
        //Cell colorization
                // Custom rendering of the table cell.
        typeColumn.setCellFactory(column -> {
            return new TreeTableCell<ITreeItemSOH, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    String text = null;
                    Node graphic = null;
                    String style = "";
                    if (item != null && !empty) {
                        text = item;
                        // Style all dates in March with a different color.
                        if (item.equals(SOHObjectType.Sector.name())) {
                            style = "-fx-background-color: yellow; -fx-text-fill: rgb(49, 0, 23);";
                        } else if (item.equals(SOHObjectType.Galaxy.name())) {
                            style = "-fx-background-color: red ; -fx-text-fill: rgb(49, 255, 23);";
                        } else if (item.equals(SOHObjectType.Starmap.name())) {
                            style = "-fx-background-color: green ; -fx-text-fill: rgb(49, 0, 255);";
                        } else {
                            setStyle("");
                        }
                    }
                    setText(text);
                    setStyle(style);
                    setGraphic(graphic);
                }
            };
        });
        
        qualityZone1Column.setCellFactory(QualityColorization.forTreeTableColumn());
        qualityZone2Column.setCellFactory(QualityColorization.forTreeTableColumn());
        qualityZone3Column.setCellFactory(QualityColorization.forTreeTableColumn());

        treeTableView = new TreeTableView<>();
        treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        treeTableView.getColumns().setAll(objectColumn, typeColumn, coordinatesColumn, zoneColumn, qualityZone1Column, qualityZone2Column, qualityZone3Column);
        treeTableView.setTableMenuButtonVisible(true);
        
        //Multiple row selection
        treeTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        treeTableView.getSelectionModel().setCellSelectionEnabled(false);

        //Selection changed
        treeTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            tableTreeExplorerController.treeSelectionChanged(treeTableView.getSelectionModel().getSelectedItems());
        });
        
        treeTableView.setPrefHeight(2000);
    }
    
    @Override
    public Node getViewElement() {
        return treeTableView;
    }


    
    void setNewTableContent(){
        treeTableView.setRoot(controller.getModel().getTreeRoot());
    }
    
    private void updateVisibility() {
       if (controller.getModel().isShowViewTableTree()) {
            this.controller.getCore().getSplit().getItems().add(0, this.treeTableView);
       }
       else {
           this.controller.getCore().getSplit().getItems().remove(this.treeTableView);
       }
    }

    @Override
    public void update(FeedbackCode code) {
        switch(code) {
            case REFRESH_ALL:
            case MAIN_DATA_CHANGED:
            case BBCODE_GENERATED:
                setNewTableContent();
                break;
            case TREETABLE_VIEW_CHANGED:
                updateVisibility();
                break;
        } 
        
    }
}
