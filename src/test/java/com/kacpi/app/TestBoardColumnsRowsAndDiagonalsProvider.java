package com.kacpi.app;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Kacper Staszek
 */
public class TestBoardColumnsRowsAndDiagonalsProvider {
    @Test
    public void checkIfNumbersAreValid(){
        Board board = new Board(3,4);
        BlocksOfFieldsProvider blocksOfFieldsProvider = new BlocksOfFieldsProvider(board);

    }
}
