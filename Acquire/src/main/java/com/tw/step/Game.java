package com.tw.step;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Turn turn;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean hasPlayer(Player player) {
        return players.contains(player);
    }

    public void distributeTile(Tile tile) {
        int currentTurn = turn.getCurrentTurn();
        Player currentPlayer = players.get(currentTurn);
        currentPlayer.addTile(tile);
    }
}
