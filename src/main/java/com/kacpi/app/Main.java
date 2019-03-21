package com.kacpi.app;


import java.util.Scanner;

/**
 * @author Kacper Staszek
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("2\n2\n0,0\n0,1\n1,1\n0,2\n2,2\n0,0\n0,1\n1,1\n0,2\n2,2\n0,0\n0,1\n1,1\n0,2\n2,2");
        Scanner standardScanner = new Scanner(System.in);
        Menu menu = new Menu(new InputKeyboardProvider(standardScanner));
        menu.startMenu();
    }
}
