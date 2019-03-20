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
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(0, 2, Figure.CIRCLE),
                        new MoveCoordinates(0, 3, Figure.CIRCLE),
                        new MoveCoordinates(0, 4, Figure.CIRCLE),
                        new MoveCoordinates(0, 1, Figure.CIRCLE)),
                        Arrays.asList(false, false, false, false, true)},
                {new Settings(5, 5, 5), Arrays.asList(
                        new MoveCoordinates(0, 0, Figure.CIRCLE),
                        new MoveCoordinates(0, 1, Figure.CIRCLE),
                        new MoveCoordinates(0, 2, Figure.CIRCLE),
                        new MoveCoordinates(0, 3, Figure.CIRCLE),
                        new MoveCoordinates(1, 3, Figure.CROSS),
                        new MoveCoordinates(0, 4, Figure.CIRCLE)),
                        Arrays.asList(false, false, false, false, false, true)},
        };
    }



//    @Test(dataProvider = "rowData")
//    public void testIfAnyoneWinByRow(Settings settings, List<MoveCoordinates> moves, List<Boolean> results) {
//        Board board = new Board(settings);
//        BoardUpdater updater = new BoardUpdater(board);
//        WinnerChecker winnerChecker = new WinnerChecker(board);
//        for (int i = 0; i < moves.size(); i++) {
//            updater.updateBoard(moves.get(i));
//            boolean result = winnerChecker.checkIfAnyoneWonRows(moves.get(i));
//            boolean expected = results.get(i);
//            Assert.assertEquals(result, expected);
//        }
//
//    }
//
//    @Test(dataProvider = "columnData")
//    public void testIfAnyoneWinByColumn(Settings settings, List<MoveCoordinates> moves, List<Boolean> results) {
//        Board board = new Board(settings);
//        BoardUpdater updater = new BoardUpdater(board);
//        WinnerChecker winnerChecker = new WinnerChecker(board);
//        for (int i = 0; i < moves.size(); i++) {
//            updater.updateBoard(moves.get(i));
//            boolean result = winnerChecker.checkIfAnyoneWonColumns(moves.get(i));
//            boolean expected = results.get(i);
//            Assert.assertEquals(result, expected);
//        }
//    }
//
//    @Test(dataProvider = "diagonalData")
//    public void testIfAnyoneWinByDiagonal(Settings settings, List<MoveCoordinates> moves, List<Boolean> results) {
//        Board board = new Board(settings);
//        BoardUpdater updater = new BoardUpdater(board);
//        WinnerChecker winnerChecker = new WinnerChecker(board);
//        for (int i = 0; i < moves.size(); i++) {
//            updater.updateBoard(moves.get(i));
//            boolean result = winnerChecker.checkIfAnyoneWonDiagonals(moves.get(i));
//            boolean expected = results.get(i);
//            Assert.assertEquals(result, expected);
//        }
//    }
//
//    @Test(dataProvider = "diagonalDataOtherSide")
//    public void testIfAnyoneWinByDiagonalOtherSide(Settings settings, List<MoveCoordinates> moves, List<Boolean> results) {
//        Board board = new Board(settings);
//        BoardUpdater updater = new BoardUpdater(board);
//        WinnerChecker winnerChecker = new WinnerChecker(board);
//        for (int i = 0; i < moves.size(); i++) {
//            updater.updateBoard(moves.get(i));
//            boolean result = winnerChecker.checkIfAnyoneWonDiagonalsOtherSide(moves.get(i));
//            boolean expected = results.get(i);
//            Assert.assertEquals(result, expected);
//        }
//    }
//
//
//    @DataProvider
//    public static Object[][] diagonalDataOtherSide() {
//        return new Object[][]{
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(2, 0, Figure.CIRCLE),
//                        new MoveCoordinates(1, 1, Figure.CIRCLE),
//                        new MoveCoordinates(0, 2, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(5, 5, 3), Arrays.asList(
//                        new MoveCoordinates(4, 2, Figure.CIRCLE),
//                        new MoveCoordinates(3, 3, Figure.CIRCLE),
//                        new MoveCoordinates(2, 4, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(5, 5, 3), Arrays.asList(
//                        new MoveCoordinates(0, 2, Figure.CIRCLE),
//                        new MoveCoordinates(2, 2, Figure.CIRCLE),
//                        new MoveCoordinates(0, 4, Figure.CIRCLE),
//                        new MoveCoordinates(1, 3, Figure.CIRCLE)),
//                        Arrays.asList(false, false, false, true)},
//
//        };
//    }
//
//    @DataProvider
//    public static Object[][] diagonalData() {
//        return new Object[][]{
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(1, 1, Figure.CIRCLE),
//                        new MoveCoordinates(2, 2, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(2, 2, Figure.CIRCLE),
//                        new MoveCoordinates(1, 1, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(0, 2, Figure.CIRCLE),
//                        new MoveCoordinates(2, 2, Figure.CIRCLE),
//                        new MoveCoordinates(1, 2, Figure.CIRCLE)),
//                        Arrays.asList(false, false, false)},
//                {new Settings(5, 5, 3), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(1, 0, Figure.CIRCLE),
//                        new MoveCoordinates(1, 1, Figure.CIRCLE),
//                        new MoveCoordinates(2, 2, Figure.CIRCLE)),
//                        Arrays.asList(false, false, false, true)},
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(2, 2, Figure.CIRCLE),
//                        new MoveCoordinates(1, 1, Figure.CIRCLE),
//                        new MoveCoordinates(0, 0, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(5, 5, 3), Arrays.asList(
//                        new MoveCoordinates(4, 4, Figure.CIRCLE),
//                        new MoveCoordinates(3, 3, Figure.CIRCLE),
//                        new MoveCoordinates(2, 2, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//        };
//    }
//
//    @DataProvider
//    public static Object[][] rowData() {
//        return new Object[][]{
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(2, 0, Figure.CIRCLE),
//                        new MoveCoordinates(1, 0, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(0, 1, Figure.CIRCLE),
//                        new MoveCoordinates(1, 1, Figure.CIRCLE),
//                        new MoveCoordinates(2, 1, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(0, 2, Figure.CIRCLE),
//                        new MoveCoordinates(2, 2, Figure.CIRCLE),
//                        new MoveCoordinates(1, 2, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(5, 5, 5), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(1, 0, Figure.CIRCLE),
//                        new MoveCoordinates(2, 0, Figure.CIRCLE),
//                        new MoveCoordinates(3, 0, Figure.CIRCLE),
//                        new MoveCoordinates(4, 0, Figure.CIRCLE)),
//                        Arrays.asList(false, false, false, false, true)},
//                {new Settings(5, 5, 5), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(1, 0, Figure.CIRCLE),
//                        new MoveCoordinates(2, 0, Figure.CIRCLE),
//                        new MoveCoordinates(3, 0, Figure.CIRCLE),
//                        new MoveCoordinates(3, 1, Figure.CROSS),
//                        new MoveCoordinates(4, 0, Figure.CIRCLE)),
//                        Arrays.asList(false, false, false, false, false, true)},
//                {new Settings(5, 3, 3), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(1, 0, Figure.CIRCLE),
//                        new MoveCoordinates(3, 0, Figure.CIRCLE),
//                        new MoveCoordinates(2, 0, Figure.CIRCLE)),
//                        Arrays.asList(false, false, false, true)},
//        };
//    }
//
//    @DataProvider
//    public static Object[][] columnData() {
//        return new Object[][]{
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(0, 1, Figure.CIRCLE),
//                        new MoveCoordinates(0, 2, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(1, 0, Figure.CIRCLE),
//                        new MoveCoordinates(1, 2, Figure.CIRCLE),
//                        new MoveCoordinates(1, 1, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(3, 3, 3), Arrays.asList(
//                        new MoveCoordinates(2, 0, Figure.CIRCLE),
//                        new MoveCoordinates(2, 1, Figure.CIRCLE),
//                        new MoveCoordinates(2, 2, Figure.CIRCLE)),
//                        Arrays.asList(false, false, true)},
//                {new Settings(5, 5, 5), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(0, 2, Figure.CIRCLE),
//                        new MoveCoordinates(0, 3, Figure.CIRCLE),
//                        new MoveCoordinates(0, 4, Figure.CIRCLE),
//                        new MoveCoordinates(0, 1, Figure.CIRCLE)),
//                        Arrays.asList(false, false, false, false, true)},
//                {new Settings(5, 5, 5), Arrays.asList(
//                        new MoveCoordinates(0, 0, Figure.CIRCLE),
//                        new MoveCoordinates(0, 1, Figure.CIRCLE),
//                        new MoveCoordinates(0, 2, Figure.CIRCLE),
//                        new MoveCoordinates(0, 3, Figure.CIRCLE),
//                        new MoveCoordinates(1, 3, Figure.CROSS),
//                        new MoveCoordinates(0, 4, Figure.CIRCLE)),
//                        Arrays.asList(false, false, false, false, false, true)},
//        };
//    }

}


