package com.kacpi.app;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Kacper Staszek
 * provides all language determinated messages.
 */
class MessagePrinter {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("OX", new Locale("pl", "PL"));

    String provideMessage(String key) {
        System.out.println(resourceBundle.getString(key));
        return resourceBundle.getString(key);
    }

    void changeLanguage(Language language){
        switch (language){
            case EN: resourceBundle = ResourceBundle.getBundle("OX",new Locale("en","EN"));
            break;
            case PL: resourceBundle = ResourceBundle.getBundle("OX",new Locale("pl","PL"));
        }
    }
}
