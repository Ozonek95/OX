package com.kacpi.app;


/**
 * @author Kacper Staszek
 */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(new InputKeyboardProvider());
        menu.startMenu();
    }
}
