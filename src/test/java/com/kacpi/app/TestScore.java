package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
@Test
public class TestScore {
    @Test
    public void testIfPlayersScoreUpgrade(){
        Player player = new Player("Name",Figure.CIRCLE);
        int score = player.getScore();
        player.addScore(3);
        Assert.assertTrue(score<player.getScore());
    }
}
