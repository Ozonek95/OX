package com.kacpi.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Kacper Staszek
 * Defalut main class
 */
class MainAuto {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        if(args.length==1){

            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                String line;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line).append(System.lineSeparator());
                }
                Menu menu = new Menu(new InputKeyboardProvider(new Scanner(stringBuilder.toString())));
                menu.startMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
           Menu menu = new Menu(new InputKeyboardProvider(new Scanner(System.in)));
           menu.startMenu();
        }

    }
}
