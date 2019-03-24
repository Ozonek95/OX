package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
@Test
public class GameInformationTest {
    public void testGameInformationChangePlayers() throws IllegalGameSettings {
        GameInformation gameInformation = new GameInformation(new Settings(3,3,3));
        String playerName = gameInformation.getPlayerName();
        gameInformation.changePlayer();
        String playerNameAfterChange = gameInformation.getPlayerName();
        Assert.assertNotEquals(playerName,playerNameAfterChange);
    }

    public void testGameInformationChangesScore() throws IllegalGameSettings {
        GameInformation gameInformation = new GameInformation(new Settings(3,3,3));
        int score = gameInformation.getScore();
        gameInformation.addScore();
        int scoreAfterChange = gameInformation.getScore();
        Assert.assertEquals(score+3,scoreAfterChange);
    }

    public void testGameInformationDraw() throws IllegalGameSettings {
        GameInformation gameInformation = new GameInformation(new Settings(3,3,3));
        int score = gameInformation.getScore();
        gameInformation.changePlayer();
        int score2 = gameInformation.getScore();
        gameInformation.draw();
        int scoreAfterChange = gameInformation.getScore();
        gameInformation.changePlayer();
        int scoreAfterChange2 = gameInformation.getScore();
        gameInformation.getWinner();
        int i = gameInformation.roundsPlayed();

        Assert.assertEquals(score+1,scoreAfterChange);
        Assert.assertEquals(score2+1,scoreAfterChange2);
        Assert.assertEquals(i,1);
    }
    public void testRoundCounterWorks(){

    }

}