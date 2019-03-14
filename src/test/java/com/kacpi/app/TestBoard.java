package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
@Test
public class TestBoard {
    public void testBoardCreation(){
        Board board = new Board(3,3);
        Assert.assertNotNull(board);
    }
    public void testBoardFieldsNumber(){
        Board board = new Board(3,3);
        int numberOfFields = board.getFieldsNumber();
        Assert.assertEquals(9,numberOfFields);
    }
    public void testAllFieldsOnStartAreEmpty(){
        Board board = new Board(5,3);
        //TO DO for
        Field field = board.getField(3,2);
        Assert.assertEquals(field.getState(), Figure.EMPTY);
    }
}
