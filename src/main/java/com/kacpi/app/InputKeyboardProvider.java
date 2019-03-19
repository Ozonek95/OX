package com.kacpi.app;

import java.util.Scanner;

/**
 * @author Kacper Staszek
 */
public class InputKeyboardProvider implements InputProvider {
    private Scanner scanner = new Scanner(System.in);
//    private MoveValidator moveValidator;
//    private MoveProvider moveProvider;

    @Override
    public String getMove() {
        System.out.println("Provide move please");
        return scanner.nextLine();
    }
}



//        while (!validMove){
//            System.out.println("Provide move, please.");
//            move=scanner.nextLine();
//            try {
//                MoveCoordinates moveCoordinates = moveProvider.provideCoordinates(move);
//            } catch (NumberFormatException exception){
//                System.err.print("Bad coordinates, try again");
//            }
//        }