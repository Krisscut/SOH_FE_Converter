
package com.shores.fe.starmap.viewer.views;

import com.shores.fe.starmap.viewer.interfaces.IView;
import com.shores.fe.starmap.viewer.models.ConverterTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import org.controlsfx.control.TaskProgressView;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.FontAwesome.Glyph;


public class TaskHistoryView implements IView {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    StackPane stackPane;
    TaskProgressView<ConverterTask> taskView;
    private int taskCounter;
    
    private FontAwesome fontAwesome = new FontAwesome();

    public TaskHistoryView() {
        initUIComponents();
        setUpComponentsLocation();
        addEventHandler();
    }

    @Override
    public void initUIComponents() {
        taskView = new TaskProgressView<>();
        taskView.setMaxWidth(250);
        taskView.setMaxHeight(140);
        taskView.setGraphicFactory(task -> taskViewGraphicFactory(task));
        
        stackPane = new StackPane();
        stackPane.setStyle("-fx-border-color: black; -fx-border-insets: 5;");
    }

    @Override
    public void setUpComponentsLocation() {
        stackPane.getChildren().add(taskView);
        StackPane.setAlignment(taskView, Pos.CENTER);
    }

    @Override
    public void addEventHandler() {
    }

    @Override
    public Node getViewElement() {
        return stackPane;
    }
    
    public void startTask() {
        taskCounter++;
        ConverterTask task = new ConverterTask("Task #" + taskCounter);
        
        // add to the UI
        taskView.getTasks().add(task);
        // execute task
        executorService.submit(task);
    }

    private Node taskViewGraphicFactory(ConverterTask task) {
        org.controlsfx.glyphfont.Glyph result = null;
        switch (task.getType()) {
            case TYPE1:
                result = fontAwesome.create(Glyph.MOBILE_PHONE).size(24)
                        .color(Color.RED);
                break;
            case TYPE2:
                result = fontAwesome.create(Glyph.COMPASS).size(24)
                        .color(Color.GREEN);
                break;
            case TYPE3:
                result = fontAwesome.create(Glyph.APPLE).size(24)
                        .color(Color.BLUE);
                break;
            default:
        }

        if (result != null) {
            result.setEffect(new DropShadow(8, Color.GRAY));
            result.setAlignment(Pos.CENTER);

            /*
             * We have to make sure all glyps have the same size. Otherwise
             * the progress cells will not be aligned properly.
             */
            result.setPrefSize(24, 24);
        }

        return result;
    }
    
}
