package com.kacpi.app;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */

public class TestInputProvider {
    @Test
    public void testInputProvider(){
        InputKeyboardProvider inputProvider = Mockito.mock(InputKeyboardProvider.class);
        Mockito.when(inputProvider.getInput()).thenReturn("1,1");

        String move = inputProvider.getInput();
        Assert.assertEquals(move,"1,1");
    }
}

