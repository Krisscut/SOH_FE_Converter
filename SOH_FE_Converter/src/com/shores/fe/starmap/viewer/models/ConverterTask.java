
package com.shores.fe.starmap.viewer.models;

import javafx.concurrent.Task;

public class ConverterTask extends Task<Void>{
    private TaskType type;

    public ConverterTask(String title) {
        updateTitle(title);

        type = TaskType.values()[(int) (Math.random() * 3)];
    }

    public TaskType getType() {
        return type;
    }

    @Override
    protected Void call() throws Exception {

        if (Math.random() < .3) {
            updateMessage("First we sleep ....");
            Thread.sleep(2500);
        }

        int max = 10000000;
        for (int i = 0; i < max; i++) {
            if (isCancelled()) {
                break;
            }
            updateMessage("Message " + i);
            updateProgress(i, max);
        }

        updateProgress(0, 0);
        done();
        return null;
    }
    
}
