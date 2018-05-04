package com.tw.step;

import javax.management.AttributeList;
import java.util.ArrayList;

public class Player {
    private final String name;
    private ArrayList<Tile> tiles;

    public Player(String name) {
        this.name = name;
        this.tiles = new ArrayList<>();
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }
}
