package com.kacpi.app;


/**
 * @author Kacper Staszek
 */
public class Main {
    public static void main(String[] args) {

        Settings settings = null;
        try {
            settings = new Settings(1,1,4);
        } catch (IllegalGameSettings illegalGameSettings) {
            illegalGameSettings.printStackTrace();
        }
        Game game = new Game(settings);
        game.playSmallMatch();

    }


}
