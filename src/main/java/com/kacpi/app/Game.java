package com.kacpi.app;

import java.util.List;

/**
 * @author Kacper Staszek
 */
public class Game {
    private Board board;
    private List<Player> players;
    private BoardPrinter boardPrinter;
    private BoardUpdater boardUpdater;
    private MoveProvider moveProvider;
    private MoveValidator moveValidator = new MoveValidator(board);
    private InputProvider inputProvider = new InputKeyboardProvider();
    private Boolean haveWinner =  false;

    public void play(){
        while (!haveWinner){
            String move = inputProvider.getMove();



        }
    }

    MoveCoordinates getValidMove(){
        boolean validMove = false;
        MoveCoordinates moveCoordinates = null;
        while (!validMove){
            String move = inputProvider.getMove();
            try {
                moveCoordinates = moveProvider.provideCoordinates(move);
                moveValidator.validateMove(moveCoordinates);
            } catch (NumberFormatException e){
                System.err.print("Bad move coordinates");
            }

        }
        return moveCoordinates;
    }


}
