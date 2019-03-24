package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Scanner;


/**
 * @author Kacper Staszek
 */
@Test
public class MenuTest {
    public void testMenuSettingsChanges(){
        Scanner scanner = new Scanner("5\n5\n5\n");
        InputProvider inputProvider = new UserInput(scanner);
        Menu menu = new Menu(inputProvider);
        Settings settings = menu.getSettings();
        menu.createSettings();
        int columnsAfterChange = settings.getColumns();
        int rowsAfterChange = settings.getRows();
        int patternToWinLength = settings.getPatternToWinLength();
        Assert.assertEquals(columnsAfterChange,5);
        Assert.assertEquals(rowsAfterChange,5);
        Assert.assertEquals(patternToWinLength,5);
    }
}