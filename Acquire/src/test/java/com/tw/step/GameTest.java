package com.tw.step;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameTest {

    private Game game;
    private Player aditi;

    @Before
    public void setUp() {
        game = new Game();
        aditi = new Player("Aditi");
    }

    @Test
    public void shouldAddPlayer() {
        game.addPlayer(aditi);
        assertTrue(game.hasPlayer(aditi));
    }

    @Test
    public void shouldDistributeTiles() {
        game.distributeTile();
    }
}
