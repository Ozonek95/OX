package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
public class TestBoardUpdater {
    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                safeXMove(3, 3, 2, 2),
                safeXMove(3, 2, 2, 1),
            {10,12,3,2,Figure.CROSS,Figure.CROSS},
            {20,20,0,0,Figure.CROSS,Figure.CROSS},
            {5,5,4,4,Figure.CROSS,Figure.CROSS},
            {3,3,1,1,Figure.CROSS,Figure.CROSS},
            {100,100,0,99,Figure.CROSS,Figure.CROSS},
            {4,4,0,1,Figure.CROSS,Figure.CROSS}
        };
    }

    private static Object[] safeXMove(int rows, int cols, int moveX, int moveY) {
        return new Object[]{rows, cols, moveX, moveY, Figure.CROSS, Figure.CROSS};
    }

    @Test(dataProvider = "data")
    public void testIfBoardChangeAfterValidMove(int rows,int columns, int rowCoordinate, int columnCoordinate, Figure figure,Figure expected) throws InvalidMoveException {
        Board board = new Board(rows,columns);
        MoveCoordinates moveCoordinates = new MoveCoordinates(rowCoordinate,columnCoordinate,figure);
        MoveValidator moveValidator = new MoveValidator(board);
        boolean result = moveValidator.validateMove(moveCoordinates);
        BoardUpdater boardUpdater = new BoardUpdater(board);
        if(result) {
            boardUpdater.updateBoard(moveCoordinates);
        }
        Field field = board.getField(rowCoordinate,columnCoordinate);
        Assert.assertEquals(field.getState(),expected);
    }
}
