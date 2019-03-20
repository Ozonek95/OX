package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
public class SettingsTest {
    @DataProvider
    public static Object[][] dataToExceptions() {
        return new Object[][]{
                {3, 3, 5, new IllegalGameSettings("")},
                {5, 5, 6, new IllegalGameSettings("")},
                {3, 7, 8, new IllegalGameSettings("")},
                {20, 20, 200, new IllegalGameSettings("")},
                {1, 3, 5, new IllegalGameSettings("")},
                {4, 4, 5, new IllegalGameSettings("")},
                {8095, 3, 8096, new IllegalGameSettings("")},
                {7, 7, 15, new IllegalGameSettings("")},
                {3, 2, 5, new IllegalGameSettings("")},
                {60, 64, 65, new IllegalGameSettings("")},
                {1, 2, 3, new IllegalGameSettings("")},

        };
    }

    @Test(dataProvider = "dataToExceptions")
    public void testIfSettingThrowsException(int rows, int columns, int patternToWin, Exception exception) {
        Exception exceptionToCatch = null;
        try {
            Settings settings = new Settings(rows, columns, patternToWin);
        } catch (IllegalGameSettings illegalGameSettings) {
            exceptionToCatch = illegalGameSettings;
        }
        Assert.assertEquals(exceptionToCatch.getClass(), exception.getClass());
    }

    @Test(dataProvider = "validData")
    public void testIfValidSettingsNotThrowExceptionException(int rows, int columns, int patternToWin, Exception exception) {
        Exception exceptionToCatch = null;
        try {
            Settings settings = new Settings(rows, columns, patternToWin);
        } catch (IllegalGameSettings illegalGameSettings) {
            exceptionToCatch = illegalGameSettings;
        }
        Assert.assertEquals(exceptionToCatch, exception);
    }


    @DataProvider
    public static Object[][] validData() {
        return new Object[][]{
                {5, 5, 5, null},
                {3, 5, 5, null},
                {4, 4, 4, null},
                {20, 20, 3, null},
                {30, 30, 5, null},
                {8, 7, 5, null},
                {6, 5, 2, null},
                {4, 6, 4, null},
                {5, 5, 4, null},
                {5, 5, 3, null},
                {10, 10, 3, null},
        };
    }


}
