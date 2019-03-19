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
    public static Object[][] data() {
        return new Object[][] {
            {5,5,new MoveCoordinates(6,6,Figure.CIRCLE),false},
            {5,10,new MoveCoordinates(4,9,Figure.CIRCLE),true},
            {5,5,new MoveCoordinates(4,5,Figure.CIRCLE),false},
            {5,5,new MoveCoordinates(5,4,Figure.CIRCLE),false},
            {5,3,new MoveCoordinates(1,1,Figure.CIRCLE),true},
            {2,2,new MoveCoordinates(0,0,Figure.CIRCLE),true},
            {5,5,new MoveCoordinates(-1,-1,Figure.CIRCLE),false},
            {5,1000,new MoveCoordinates(0,999,Figure.CIRCLE),true},
        };
    }
    @Test(dataProvider = "data")
    public void testIfMoveIsValidBasedOnCoordinates(int rows, int columns,
                            MoveCoordinates moveCoordinates,boolean expectedResult)
    {
        Board board = new Board(rows,columns);
        MoveValidator moveValidator = new MoveValidator(board);
        boolean validMove = moveValidator.validateMove(moveCoordinates);
        Assert.assertEquals(validMove,expectedResult);
    }

    @Test
    public void testIfMoveIsValidBasedOnCoordinatesAndFigure(){
        Board board = new Board(new Settings(3,3,3));
        MoveValidator moveValidator = new MoveValidator(board);
        boolean validMove1 = moveValidator.validateMove(new MoveCoordinates(0,0,Figure.CIRCLE));
        board.setField(0,0,Figure.CIRCLE);
        boolean validMove2 = moveValidator.validateMove(new MoveCoordinates(0,0,Figure.CIRCLE));
        boolean validMove3 = moveValidator.validateMove(new MoveCoordinates(0,0,Figure.CROSS));
        boolean validMove4 = moveValidator.validateMove(new MoveCoordinates(0,1,Figure.CROSS));
        Assert.assertTrue(validMove1);
        Assert.assertFalse(validMove2);
        Assert.assertFalse(validMove3);
        Assert.assertTrue(validMove4);

    }
}
