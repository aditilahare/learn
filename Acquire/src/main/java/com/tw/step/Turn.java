package com.tw.step;

public class Turn {
    private int currentTurn = 1;

    public Turn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public int getCurrentTurn(){
        return currentTurn;
    }
}
