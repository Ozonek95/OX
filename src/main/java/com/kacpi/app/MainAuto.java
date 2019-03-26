package com.kacpi.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kacper Staszek
 * Defalut main class
 */
class MainAuto {
    public static void main(String[] args) throws IOException {
        WinningConditionsGenerator generator = new WinningConditionsGenerator();
        List<String> strings = generator.automaticGameDrawGenerator(5, 5, 3);
        StringBuilder test = new StringBuilder();
        strings.forEach(test::append);
        if (args.length == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            Files.readAllLines(Paths.get(args[0])).forEach(s -> {
                stringBuilder.append(s).append(System.lineSeparator());
            });
            new Menu(new UserInput(new Scanner(stringBuilder.toString()))).startMenu();

        } else {
           new Menu(new UserInput(new Scanner(System.in))).startMenu();
        }
    }
}
