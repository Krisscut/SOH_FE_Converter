package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.core.Configuration.Configuration;
import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.interfaces.IView;
import java.awt.Desktop;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.control.action.Action;

public class CoreView implements IView{
    //UI components
    VBox vbox , mainVBox = null;
    SplitPane split = null;
    
    StatusBarView statusBar;
    ToolbarView toolbarView;
    NotificationPane notificationPane;
    
    //Componenets views
    private BBCodeExporterView bbCodeExporterView;
    private MenuView menuView;
    private SearchModuleView searchModuleView;
    private TableTreeExplorerView tableTreeExplorerView;

    public CoreView(MenuView menuView, SearchModuleView searchModuleView, TableTreeExplorerView tableTreeExplorerView, BBCodeExporterView bbCodeExporterView) {
        this.bbCodeExporterView = bbCodeExporterView;
        this.menuView = menuView;
        this.searchModuleView = searchModuleView;
        this.tableTreeExplorerView = tableTreeExplorerView;
        
        initUIComponents();
        setUpComponentsLocation();
        addEventHandler();
    }



    @Override
    public void initUIComponents() {
        mainVBox = new VBox();
        mainVBox.setAlignment(Pos.TOP_CENTER);

        vbox = new VBox();
        
        //Split pane to hold the main view
        split = new SplitPane();
        split.setOrientation(Orientation.VERTICAL);
 
        //vbox.getChildren().add(bbCodeExporterView.getViewElement());
        /**
        TabPane tabPane = new TabPane();
        Tab tab = new Tab();
        tab.setText("Database Converter");
        tab.setContent(vbox);
        tabPane.getTabs().add(tab);
        * */
        
        statusBar = StatusBarView.getInstance();
        toolbarView = ToolbarView.getInstance();
        
        /** Notification pane test */
        notificationPane = new NotificationPane();
        
        ImageView notifIcon = new ImageView (SOH_FE_Converter.depimg);
        notifIcon.setFitWidth(40);
        notifIcon.setPreserveRatio(true);
        notifIcon.setSmooth(true);
        notifIcon.setCache(true);
        
        notificationPane.setGraphic(notifIcon);
        notificationPane.setShowFromTop(false);
        notificationPane.getStyleClass().add(NotificationPane.STYLE_CLASS_DARK);
        notificationPane.setText("This is a work in progress software, please give feedback using the github issues system !");


    }

    @Override
    public void setUpComponentsLocation() {
        vbox.getChildren().add(searchModuleView.getViewElement());
        
        split.setDividerPositions(0.8f);
        split.getItems().addAll(tableTreeExplorerView.getViewElement(),bbCodeExporterView.getViewElement());
        
        vbox.getChildren().add(split);
        mainVBox.getChildren().addAll(menuView.getViewElement(), toolbarView.getViewElement(), vbox, statusBar.getViewElement());
        
        
        notificationPane.setContent(mainVBox);
    }

    @Override
    public void addEventHandler() {
        notificationPane.getActions().addAll(new Action("Feedback", ae -> {
            try {
                Desktop.getDesktop().browse(new URI(Configuration.GITHUB_ISSUES_URL));
            } catch (Exception ex) {
                Logger.getLogger(SOH_FE_Converter.class.getName()).log(Level.SEVERE, null, ex);
            }
            notificationPane.hide();
        }));
    }
    
    @Override
    public Node getViewElement() {
        return notificationPane;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public VBox getMainVBox() {
        return mainVBox;
    }

    public void setMainVBox(VBox mainVBox) {
        this.mainVBox = mainVBox;
    }

    public SplitPane getSplit() {
        return split;
    }

    public void setSplit(SplitPane split) {
        this.split = split;
    }

    public NotificationPane getNotificationPane() {
        return notificationPane;
    }

    public void setNotificationPane(NotificationPane notificationPane) {
        this.notificationPane = notificationPane;
    }
}
