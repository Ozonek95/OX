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
            {5,5,new MoveCoordinates(6,6),false},
            {5,10,new MoveCoordinates(4,9),true},
            {5,5,new MoveCoordinates(4,5),false},
            {5,5,new MoveCoordinates(5,4),false},
            {5,3,new MoveCoordinates(1,1),true},
            {2,2,new MoveCoordinates(0,0),true},
            {5,5,new MoveCoordinates(-1,-1),false},
            {5,1000,new MoveCoordinates(0,999),true},
        };
    }
    @Test(dataProvider = "data")
    public void testIfMoveIsValidBasedOnCoordinatesAndFigure(int rows, int columns,
             MoveCoordinates moveCoordinates,boolean expectedResult){
        Board board = new Board(rows,columns);
        MoveCoordinates coordinates = moveCoordinates;
        Player player1 = new Player("Kacper",Figure.CIRCLE);
        Move move = new Move(coordinates);
        MoveValidator moveValidator = new MoveValidator();
        boolean validMove = moveValidator.validateMove(move, player1, board);
        Assert.assertEquals(validMove,expectedResult);
    }
}
