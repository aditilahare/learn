package com.thoughtworks.step;

import java.util.ArrayList;

public class Event {
    private final ArrayList<Listener> listeners;

    public Event() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void removeListener(Listener listener){
        listeners.remove(listener);
    }

    public void full(){
        for (Listener listener : listeners) {
            listener.markAsFull();
        }
    }

    public void hasSpace() {
        for (Listener listener : listeners) {
            listener.markAsNotFull();
        }
    }
}
