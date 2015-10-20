package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.controllers.TableTreeExplorerController;
import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.ITreeItemSOH;
import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.interfaces.observability.Observer;
import com.shores.fe.starmap.viewer.models.FeedbackCode;
import com.shores.fe.starmap.viewer.models.ui.table.rendering.AtmosphereColorization;
import com.shores.fe.starmap.viewer.models.ui.table.rendering.ObjectRendering;
import com.shores.fe.starmap.viewer.models.ui.table.rendering.QualityColorization;
import com.shores.fe.starmap.viewer.models.ui.table.rendering.TypeColorization;
import com.shores.fe.starmap.viewer.models.ui.table.rendering.ZoneColorization;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
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
            new ReadOnlyStringWrapper(param.getValue().getValue().getZone().toString())
        );
        
        TreeTableColumn<ITreeItemSOH, String> atmoTypeColumn = new TreeTableColumn<>("AtmoType");
        atmoTypeColumn.setPrefWidth(70);
        atmoTypeColumn.setCellValueFactory(
            (TreeTableColumn.CellDataFeatures<ITreeItemSOH, String> param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getAtmoType().toString())
        );
        
        TreeTableColumn<ITreeItemSOH, Integer> qualityZone1Column = new TreeTableColumn<>("Quality Zone 1");
        qualityZone1Column.setPrefWidth(70);
        qualityZone1Column.setCellValueFactory(param -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getValue().getQualityZone1());
        });
        
        TreeTableColumn<ITreeItemSOH, Integer> qualityZone2Column = new TreeTableColumn<>("Quality Zone 2");
        qualityZone2Column.setPrefWidth(70);
        qualityZone2Column.setCellValueFactory(param -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getValue().getQualityZone2());
        });
        
        TreeTableColumn<ITreeItemSOH, Integer> qualityZone3Column = new TreeTableColumn<>("Quality Zone 3");
        qualityZone3Column.setPrefWidth(70);
        qualityZone3Column.setCellValueFactory(param -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getValue().getQualityZone3());
        });
        
        //Cell colorization & rendering
        objectColumn.setCellFactory(ObjectRendering.forTreeTableColumn());
        typeColumn.setCellFactory(TypeColorization.forTreeTableColumn());
        zoneColumn.setCellFactory(ZoneColorization.forTreeTableColumn());
        atmoTypeColumn.setCellFactory(AtmosphereColorization.forTreeTableColumn());
        qualityZone1Column.setCellFactory(QualityColorization.forTreeTableColumn());
        qualityZone2Column.setCellFactory(QualityColorization.forTreeTableColumn());
        qualityZone3Column.setCellFactory(QualityColorization.forTreeTableColumn());

        treeTableView = new TreeTableView<>();
        treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        treeTableView.getColumns().setAll(objectColumn, typeColumn, coordinatesColumn, zoneColumn, atmoTypeColumn, qualityZone1Column, qualityZone2Column, qualityZone3Column);
        treeTableView.setTableMenuButtonVisible(true);
        
        //Multiple row selection
        treeTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        treeTableView.getSelectionModel().setCellSelectionEnabled(false);

        //Selection changed
        //TODO sync
        treeTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            tableTreeExplorerController.treeSelectionChanged(treeTableView.getSelectionModel().getSelectedItems());
        });
        
        //Takes maximum size
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
           SOH_FE_Converter.coreView.getSplit().getItems().add(0, this.treeTableView);
       }
       else {
           SOH_FE_Converter.coreView.getSplit().getItems().remove(this.treeTableView);
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
