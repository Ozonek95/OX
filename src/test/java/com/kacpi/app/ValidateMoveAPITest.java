package com.kacpi.app;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
public class ValidateMoveAPITest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
            {3,3,3,"1,1",1,1},
            {5,5,5,"0,2",0,2},
            {5,3,5,"0,1",0,1},
            {5,5,5,"1,0",1,0},
            {5,5,5,"4,4",4,4},
            {5,5,5,"3,3",3,3},
            {5,5,5,"0,3",0,3},
            {5,5,5,"3,0",3,0},
            {5,5,5,"4,1",4,1},
        };
    }


    @Test(dataProvider = "data")
    public void testMoveValidation(int rows,int columns,int patternToWin,String input,int expecterRowCoordinate,int expectedColumnCoordinate) throws IllegalGameSettings {
        InputKeyboardProvider inputProvider = Mockito.mock(InputKeyboardProvider.class);
        Mockito.when(inputProvider.getInput()).thenReturn(input);
        Board board = new Board(new Settings(rows,columns,patternToWin));
        MoveValidator moveValidator = new MoveValidator(board);
        ValidateMoveProviderAPI validateMoveProviderAPI = new ValidateMoveProviderAPI(inputProvider,moveValidator);
        MoveCoordinates validMove = validateMoveProviderAPI.getValidMove();
        int row = validMove.getRow();
        int column = validMove.getColumn();

        Assert.assertEquals(row,expecterRowCoordinate);
        Assert.assertEquals(column,expectedColumnCoordinate);
    }
}
