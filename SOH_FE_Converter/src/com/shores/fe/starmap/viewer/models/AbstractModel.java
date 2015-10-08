package com.shores.fe.starmap.viewer.models;

import com.shores.fe.starmap.viewer.models.observability.Observable;
import com.shores.fe.starmap.viewer.models.observability.Observer;
import java.util.ArrayList;


public class AbstractModel implements Observable{
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();   

    @Override
    public void addObserver(Observer observer) {
        this.listObserver.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.listObserver.remove(observer);
    }

    @Override
    public void removeObservers() {
        this.listObserver.clear();
    }

    @Override
    public void notifyObservers(FeedbackCode code) {
        for (Observer observer : listObserver){
            observer.update(code);
        }
    }
    
}
