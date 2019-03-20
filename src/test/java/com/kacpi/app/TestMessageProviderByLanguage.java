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
        MessageProviderBasedOnLanguage messageProviderBasedOnLanguage = new MessageProviderBasedOnLanguage();
        String patternToWinLength = messageProviderBasedOnLanguage.provideMessage("patternToWinLength");
        Assert.assertEquals(patternToWinLength,"Podaj długość wzoru do zwycięstwa.");
        messageProviderBasedOnLanguage.changeLanguage(Language.EN);
        String patternToWinLength1 = messageProviderBasedOnLanguage.provideMessage("patternToWinLength");
        Assert.assertEquals(patternToWinLength1,"Provide pattern to win length.");
        messageProviderBasedOnLanguage.changeLanguage(Language.PL);
        String patternToWinLength2 = messageProviderBasedOnLanguage.provideMessage("patternToWinLength");
        Assert.assertEquals(patternToWinLength2,"Podaj długość wzoru do zwycięstwa.");
    }
}
