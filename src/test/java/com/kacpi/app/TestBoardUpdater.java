package com.kacpi.app;

import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
public class TestBoardUpdater {
    @Test
    public void testIfBoardChangeAfterValidMove(){
        Board board = new Board(3,3);
        Player player = new Player("Kacper",Figure.CIRCLE);
        MoveCoordinates moveCoordinates = new MoveCoordinates(2,2);
        Move move = new Move(moveCoordinates);
        MoveValidator moveValidator = new MoveValidator();
        boolean result = moveValidator.validateMove(move, player, board);
        //BoardUpdater boardUpdater = new BoardUpdater(board,moveCoordinates);
    }
}
