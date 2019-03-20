package com.kacpi.app;

import java.util.Scanner;

/**
 * @author Kacper Staszek
 */
public class InputKeyboardProvider implements InputProvider {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getMove() {
        return scanner.nextLine();
    }
}