package com.kacpi.app;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
public class TestMenu {
    @Test
    public void testMenuGeneratesSettingsFile() {
        InputKeyboardProvider inputProvider = Mockito.mock(InputKeyboardProvider.class);
        Mockito.when(inputProvider.getInput()).thenReturn("3");
        Menu menu = new Menu(inputProvider);
        menu.setMessageProvider(new MessageProviderBasedOnLanguage());
        Settings settings = menu.createSettings();
        Assert.assertEquals(settings.getColumns(), 3);
        Assert.assertEquals(settings.getRows(), 3);
        Assert.assertEquals(settings.getPatternToWinLength(), 3);
    }
}
