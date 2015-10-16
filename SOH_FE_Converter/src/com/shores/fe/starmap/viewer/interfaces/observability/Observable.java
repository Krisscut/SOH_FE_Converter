package com.shores.fe.starmap.viewer.interfaces.observability;

import com.shores.fe.starmap.viewer.models.FeedbackCode;

public interface Observable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void removeObservers();
    public void notifyObservers(FeedbackCode code);
}
