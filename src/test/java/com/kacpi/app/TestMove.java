package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
@Test
public class TestMove {
    @DataProvider
    public static Object[][] dataWithoutExceptions() {
        return new Object[][]{

                {5, 10, new MoveCoordinates(4, 9, Figure.CIRCLE), true},
                {5, 3, new MoveCoordinates(1, 1, Figure.CIRCLE), true},
                {2, 2, new MoveCoordinates(0, 0, Figure.CIRCLE), true},
                {5, 1000, new MoveCoordinates(0, 999, Figure.CIRCLE), true},
        };
    }

    @DataProvider
    public static Object[][] dataWithExceptions() {
        return new Object[][]{
                {5, 5, new MoveCoordinates(6, 6, Figure.CIRCLE), new InvalidMoveException("Exception")},
                {5, 5, new MoveCoordinates(4, 5, Figure.CIRCLE), new InvalidMoveException("Exception")},
                {5, 5, new MoveCoordinates(5, 4, Figure.CIRCLE), new InvalidMoveException("Exception")},
                {5, 5, new MoveCoordinates(-1, -1, Figure.CIRCLE), new InvalidMoveException("Exception")},
        };
    }

    @Test(dataProvider = "dataWithoutExceptions")
    public void testIfMoveIsValidBasedOnCoordinates(int rows, int columns,
                                                    MoveCoordinates moveCoordinates, boolean expectedResult) throws InvalidMoveException {
        Board board = new Board(rows, columns);
        MoveValidator moveValidator = new MoveValidator(board);
        boolean validMove = moveValidator.validateMove(moveCoordinates);
        Assert.assertEquals(validMove, expectedResult);
    }

    @Test(dataProvider = "dataWithExceptions")
    public void testIfMoveIsInvalidAndThrowsExceptionBasedOnCoordinates(int rows, int columns,
                                                                        MoveCoordinates moveCoordinates, Exception e) {
        Board board = new Board(rows, columns);
        MoveValidator moveValidator = new MoveValidator(board);
        Exception exception = null;
        try {
            moveValidator.validateMove(moveCoordinates);
        } catch (InvalidMoveException except) {
            exception = except;
        }
        Assert.assertEquals(e.getClass(), exception.getClass());
    }
}
