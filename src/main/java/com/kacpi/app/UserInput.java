package com.kacpi.app;

import java.util.Scanner;

/**
 * @author Kacper Staszek
 */
public class UserInput implements InputProvider {
    private final Scanner scanner;

    UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}