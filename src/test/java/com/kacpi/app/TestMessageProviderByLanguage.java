package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
@Test
public class TestMessageProviderByLanguage {
    @Test
    public void testMessages(){
        MessagePrinter messagePrinter = new MessagePrinter();
        String patternToWinLength = messagePrinter.provideMessage("patternToWinLength");
        Assert.assertEquals(patternToWinLength,"Podaj długość wzoru do zwycięstwa.");
        messagePrinter.changeLanguage(Language.EN);
        String patternToWinLength1 = messagePrinter.provideMessage("patternToWinLength");
        Assert.assertEquals(patternToWinLength1,"Provide pattern to win length.");
        messagePrinter.changeLanguage(Language.PL);
        String patternToWinLength2 = messagePrinter.provideMessage("patternToWinLength");
        Assert.assertEquals(patternToWinLength2,"Podaj długość wzoru do zwycięstwa.");
    }
}
