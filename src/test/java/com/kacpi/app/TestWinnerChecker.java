package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Kacper Staszek
 */
public class TestWinnerChecker {
    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
            {3,3,3, Arrays.asList(new MoveCoordinates(0,0,Figure.CIRCLE),new MoveCoordinates(0,1,Figure.CIRCLE),new MoveCoordinates(0,2,Figure.CIRCLE)),true},
            {3,3,3, Arrays.asList(new MoveCoordinates(1,1,Figure.CIRCLE),new MoveCoordinates(1,0,Figure.CIRCLE),new MoveCoordinates(1,2,Figure.CIRCLE)),true},
            {3,3,3, Arrays.asList(new MoveCoordinates(2,2,Figure.CIRCLE),new MoveCoordinates(2,0,Figure.CIRCLE),new MoveCoordinates(2,1,Figure.CIRCLE)),true},
            {3,3,3, Arrays.asList(new MoveCoordinates(2,2,Figure.CIRCLE),new MoveCoordinates(2,0,Figure.CIRCLE),new MoveCoordinates(0,1,Figure.CIRCLE)),false},
            {3,3,3, Arrays.asList(new MoveCoordinates(0,0,Figure.CIRCLE),new MoveCoordinates(1,0,Figure.CIRCLE),new MoveCoordinates(2,0,Figure.CIRCLE)),true},
            {3,3,3, Arrays.asList(new MoveCoordinates(2,2,Figure.CIRCLE),new MoveCoordinates(2,0,Figure.CIRCLE),new MoveCoordinates(2,1,Figure.CROSS)),false},
        };
    }

    @Test(dataProvider = "data")
    public void testIfThreeInColumnWinGame(int row, int columns, int patternToWin, List<MoveCoordinates> coordinates, boolean expected){
        Settings settings = new Settings(row,columns,patternToWin);
        Board board = new Board(settings);
        BoardUpdater boardUpdater = new BoardUpdater(board);
        WinnerChecker winnerChecker = new WinnerChecker();
        for (MoveCoordinates coordinate:coordinates) {
            boardUpdater.updateBoard(coordinate);
        }
        boolean result = winnerChecker.checkIfAnyoneWon(board);
        Assert.assertEquals(result,expected);
    }
}
