package com.kacpi.app;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Kacper Staszek
 */

public class TestInputProvider {
    @Test
    public void testInputProvider(){
        UserInput inputProvider = new UserInput(new Scanner("1,1\n"));
        String move = inputProvider.getInput();
        Assert.assertEquals(move,"1,1");
    }
}

