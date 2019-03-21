package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
public class SettingsTest {

    @Test
    public void testPlayerSwitching() throws IllegalGameSettings {
        Settings settings = new Settings(3,3,3);
        Player tempPlayer = settings.getPlayers().get(0);
        settings.changePlayers();
        Assert.assertEquals(tempPlayer,settings.getPlayers().get(1));
    }


    @Test(dataProvider = "dataToExceptions", expectedExceptions = IllegalGameSettings.class)
    public void testIfSettingThrowsException(int rows, int columns, int patternToWin) throws IllegalGameSettings {
       new Settings(rows, columns, patternToWin);
    }

    @Test(dataProvider = "validData")
    public void testIfValidSettingsNotThrowExceptionException(int rows, int columns, int patternToWin) {
        try {
           new Settings(rows, columns, patternToWin);
        } catch (IllegalGameSettings illegalGameSettings) {
            Assert.fail("Exception happened");
        }
    }

    @DataProvider
    public static Object[][] dataToExceptions() {
        return new Object[][]{
                {3, 3, 5},
                {5, 5, 6},
                {3, 7, 8},
                {20, 20, 200},
                {1, 3, 5},
                {4, 4, 5},
                {8095, 3, 8096},
                {7, 7, 15},
                {3, 2, 5},
                {60, 64, 65},
                {1, 2, 3},

        };
    }

    @DataProvider
    public static Object[][] validData() {
        return new Object[][]{
                {5, 5, 5},
                {3, 5, 5},
                {4, 4, 4},
                {20, 20, 3},
                {30, 30, 5},
                {8, 7, 5},
                {6, 5, 2},
                {4, 6, 4},
                {5, 5, 4},
                {5, 5, 3},
                {10, 10, 3},
        };
    }


}
