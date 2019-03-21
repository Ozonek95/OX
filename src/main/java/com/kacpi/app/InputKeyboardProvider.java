package com.kacpi.app;

import java.util.Scanner;

/**
 * @author Kacper Staszek
 */
public class InputKeyboardProvider implements InputProvider {
    private Scanner scanner;

    InputKeyboardProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}