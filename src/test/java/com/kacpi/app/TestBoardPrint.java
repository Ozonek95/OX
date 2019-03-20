package com.kacpi.app;

import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
public class TestBoardPrint {

    @Test(enabled = false)
    public void testBoardPrint(){
        try {
            BoardPrinter boardPrinter = new BoardPrinter(new Board(new Settings(3,3,3)));
            boardPrinter.printBoard();
        } catch (IllegalGameSettings illegalGameSettings) {
            illegalGameSettings.printStackTrace();
        }
    }
}
