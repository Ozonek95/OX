package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class IllegalGameSettings extends Exception {
    IllegalGameSettings(String message) {
        super(message);
    }
}
