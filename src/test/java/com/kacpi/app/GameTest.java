package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.*;

/**
 * @author Kacper Staszek
 */
@Test
public class GameTest {

    public void endToEndTestFor3_3_3_Settings(){
        InputProvider inputProvider = new InputKeyboardProvider(new Scanner(
                "0,0\n0,1\n1,1\n0,2\n2,2\n0,0\n0,1\n1,1\n0,2\n2,2\n0,0\n0,1\n1,1\n0,2\n2,2"));
        Settings settings = null;
        try {
            settings = new Settings(3,3,3);
        } catch (IllegalGameSettings illegalGameSettings) {
            illegalGameSettings.printStackTrace();
        }
        Game game = new Game(settings,new MessageProviderBasedOnLanguage(),inputProvider,new GameInformation(settings));
        game.playMatch();
        String winner = game.getGameInformation().getWinner();
        Assert.assertEquals(winner,"Player1");
    }
    public void endToEndTestFor3_3_3_SettingsExpectDraw(){
        InputProvider inputProvider = new InputKeyboardProvider(new Scanner(
                "0,0\n1,1\n0,2\n0,1\n2,1\n1,2\n1,0\n2,0\n2,2\n0,0\n1,1\n0,2\n0,1\n2,1\n1,2\n1,0\n2,0\n2,2\n0,0\n1,1\n0,2\n0,1\n2,1\n1,2\n1,0\n2,0\n2,2\n"));
        Settings settings = null;
        try {
            settings = new Settings(3,3,3);
        } catch (IllegalGameSettings illegalGameSettings) {
            illegalGameSettings.printStackTrace();
        }
        Game game = new Game(settings,new MessageProviderBasedOnLanguage(),inputProvider,new GameInformation(settings));
        game.playMatch();
        String winner = game.getGameInformation().getWinner();
        Assert.assertEquals(winner,"DRAW!");
    }
}