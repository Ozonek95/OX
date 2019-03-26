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
        MessageSupplier messageSupplier = new MessageSupplier();
        String patternToWinLength = messageSupplier.provideMessage("patternToWinLength");
        Assert.assertEquals(patternToWinLength,"Podaj długość wzoru do zwycięstwa.");
        messageSupplier.changeLanguage(Language.EN);
        String patternToWinLength1 = messageSupplier.provideMessage("patternToWinLength");
        Assert.assertEquals(patternToWinLength1,"Provide pattern to win length.");
        messageSupplier.changeLanguage(Language.PL);
        String patternToWinLength2 = messageSupplier.provideMessage("patternToWinLength");
        Assert.assertEquals(patternToWinLength2,"Podaj długość wzoru do zwycięstwa.");
    }
}
