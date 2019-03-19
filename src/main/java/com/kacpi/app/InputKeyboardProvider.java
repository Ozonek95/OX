package com.kacpi.app;

import java.util.Scanner;

/**
 * @author Kacper Staszek
 */
public class InputKeyboardProvider implements InputProvider {
    private Scanner scanner = new Scanner(System.in);
    private MoveValidator validator = new MoveValidator(new Board(2,4));
    @Override
    public String getMove() {
        String move = scanner.nextLine();
        MoveProvider provider = new MoveProvider();
        MoveCoordinates moveCoordinates = provider.provideCoordinates(move);
        validator.validateMove(moveCoordinates);
        return  scanner.nextLine();
    }
}
