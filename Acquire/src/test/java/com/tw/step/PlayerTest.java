package com.tw.step;

import org.junit.Before;

public class PlayerTest {

    private Player aditi;
    private Tile tile;

    @Before
    public void setUp() {
        aditi = new Player("Aditi");
        tile = new Tile();
    }

    //    @Test
//    public void shouldAbleToPlaceATile() {
//        aditi.placeTile(tile);
//    }
}