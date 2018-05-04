package com.thoughtworks.step;

public class Assistant implements Listener {
    @Override
    public void markAsFull() {
        System.out.println("No Space!");
    }

    @Override
    public void markAsNotFull() {
        System.out.println("Space Available!");
    }
}
