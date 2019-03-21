package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kacper Staszek
 */
public class TestWinnerChecker {

    @Test(dataProvider = "data")
    public void testIfAnyoneWon(Settings settings, List<MoveCoordinates> moves, List<Boolean> results) {
        Board board = new Board(settings);
        BoardUpdater updater = new BoardUpdater(board);
        WinnerChecker winnerChecker = new WinnerChecker(board);
        for (int i = 0; i < moves.size(); i++) {
            updater.updateBoard(moves.get(i));
            boolean result = winnerChecker.checkIfAnyoneWon(moves.get(i));
            boolean expected = results.get(i);
            Assert.assertEquals(result, expected);
        }

    }

    @DataProvider
    public static Object[][] data() throws IllegalGameSettings {
        return new Object[][]{
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(2, 0, Figure.CIRCLE),
                        new MoveCoordinates(1, 1, Figure.CIRCLE),
                        new MoveCoordinates(0, 2, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(5, 5, 3), Arrays.asList(
                        new MoveCoordinates(4, 2, Figure.CIRCLE),
                        new MoveCoordinates(3, 3, Figure.CIRCLE),
                        new MoveCoordinates(2, 4, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(5, 5, 3), Arrays.asList(
                        new MoveCoordinates(0, 2, Figure.CIRCLE),
                        new MoveCoordinates(2, 2, Figure.CIRCLE),
                        new MoveCoordinates(0, 4, Figure.CIRCLE),
                        new MoveCoordinates(1, 3, Figure.CIRCLE)),
                        Arrays.asList(false, false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(1, 1, Figure.CIRCLE),
                        new MoveCoordinates(2, 2, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(2, 2, Figure.CIRCLE),
                        new MoveCoordinates(1, 1, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(0, 2, Figure.CIRCLE),
                        new MoveCoordinates(2, 2, Figure.CIRCLE),
                        new MoveCoordinates(1, 2, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(5, 5, 3), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(1, 0, Figure.CIRCLE),
                        new MoveCoordinates(1, 1, Figure.CIRCLE),
                        new MoveCoordinates(2, 2, Figure.CIRCLE)),
                        Arrays.asList(false, false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(2, 2, Figure.CIRCLE),
                        new MoveCoordinates(1, 1, Figure.CIRCLE),
                        new MoveCoordinates(0, 0, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(5, 5, 3), Arrays.asList(
                        new MoveCoordinates(4, 4, Figure.CIRCLE),
                        new MoveCoordinates(3, 3, Figure.CIRCLE),
                        new MoveCoordinates(2, 2, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(2, 0, Figure.CIRCLE),
                        new MoveCoordinates(1, 0, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(0, 1, Figure.CIRCLE),
                        new MoveCoordinates(1, 1, Figure.CIRCLE),
                        new MoveCoordinates(2, 1, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(0, 2, Figure.CIRCLE),
                        new MoveCoordinates(2, 2, Figure.CIRCLE),
                        new MoveCoordinates(1, 2, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(5, 5, 5), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(1, 0, Figure.CIRCLE),
                        new MoveCoordinates(2, 0, Figure.CIRCLE),
                        new MoveCoordinates(3, 0, Figure.CIRCLE),
                        new MoveCoordinates(4, 0, Figure.CIRCLE)),
                        Arrays.asList(false, false, false, false, true)},
                {new Settings(5, 5, 5), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(1, 0, Figure.CIRCLE),
                        new MoveCoordinates(2, 0, Figure.CIRCLE),
                        new MoveCoordinates(3, 0, Figure.CIRCLE),
                        new MoveCoordinates(3, 1, Figure.CROSS),
                        new MoveCoordinates(4, 0, Figure.CIRCLE)),
                        Arrays.asList(false, false, false, false, false, true)},
                {new Settings(5, 3, 3), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(1, 0, Figure.CIRCLE),
                        new MoveCoordinates(3, 0, Figure.CIRCLE),
                        new MoveCoordinates(2, 0, Figure.CIRCLE)),
                        Arrays.asList(false, false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(0, 1, Figure.CIRCLE),
                        new MoveCoordinates(0, 2, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(1, 0, Figure.CIRCLE),
                        new MoveCoordinates(1, 2, Figure.CIRCLE),
                        new MoveCoordinates(1, 1, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(3, 3, 3), Arrays.asList(
                        new MoveCoordinates(2, 0, Figure.CIRCLE),
                        new MoveCoordinates(2, 1, Figure.CIRCLE),
                        new MoveCoordinates(2, 2, Figure.CIRCLE)),
                        Arrays.asList(false, false, true)},
                {new Settings(5, 5, 5), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CROSS),
                        new MoveCoordinates(0, 2, Figure.CROSS),
                        new MoveCoordinates(0, 3, Figure.CROSS),
                        new MoveCoordinates(0, 4, Figure.CROSS),
                        new MoveCoordinates(0, 1, Figure.CROSS)),
                        Arrays.asList(false, false, false, false, true)},
                {new Settings(5, 5, 5), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(0, 1, Figure.CIRCLE),
                        new MoveCoordinates(0, 2, Figure.CIRCLE),
                        new MoveCoordinates(0, 3, Figure.CIRCLE),
                        new MoveCoordinates(1, 3, Figure.CROSS),
                        new MoveCoordinates(0, 4, Figure.CIRCLE)),
                        Arrays.asList(false, false, false, false, false, true)},

                {new Settings(15, 10, 4), Arrays.asList(
                        new MoveCoordinates(0, 7, Figure.CROSS),
                        new MoveCoordinates(1, 7, Figure.CROSS),
                        new MoveCoordinates(2, 7, Figure.CROSS),
                        new MoveCoordinates(3, 7, Figure.CROSS)),
                        Arrays.asList(false, false, false,true)}
        };
    }
}


