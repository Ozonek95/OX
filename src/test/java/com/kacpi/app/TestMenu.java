package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Kacper Staszek
 */
public class TestMenu {
    @Test
    public void testMenuGeneratesSettingsFile() {
        UserInput inputProvider = new UserInput(new Scanner("3\n3\n3\n"));
        Menu menu = new Menu(inputProvider);
        menu.setMessageProvider(new MessageSupplier());
        Settings settings = menu.createSettings();
        Assert.assertEquals(settings.getColumns(), 3);
        Assert.assertEquals(settings.getRows(), 3);
        Assert.assertEquals(settings.getPatternToWinLength(), 3);
    }
}
