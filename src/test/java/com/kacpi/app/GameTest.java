package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

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
    public void endToEndTestFor70_10_4_SettingsWithChangedNames(){
        String input = "2\n4\nKacper\nArek\n1\n9\n10\n4\n2\n2\n3,6\n2,7\n4,7\n3,7\n5,8\n1,7\n2,5\n 2,7\n3,6\n3,7\n4,7\n1,7\n5,8\n2,5\n0,0\n2,7\n0,1\n0,7\n";
        InputProvider inputProvider = new InputKeyboardProvider(new Scanner(input));
        Menu menu = new Menu(inputProvider);
        menu.startMenu();
    }
    public void testWinIn2Rounds(){
        InputProvider inputProvider = new InputKeyboardProvider(new Scanner(
                "0,0\n0,1\n1,1\n0,2\n2,2\n0,1\n0,0\n0,2\n1,1\n2,2\n1,0\n2,1\n2,0\n"));
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
}