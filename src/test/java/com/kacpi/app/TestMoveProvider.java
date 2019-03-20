package com.kacpi.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kacper Staszek
 */
@Test
public class TestMoveProvider {

    @DataProvider
    public static Object[][] data () {
        return new Object[][] {
            {"1,2",1,2},
            {"2,3",2,3},
            {"10,3",10,3},
            {"40,8",40,8},
            {"50,3",50,3},
            {"70,1",70,1},
            {"999,999",999,999},
            {"9,0",9,0},
            {"0,0",0,0},
            {"2,14",2,14},
            {"66,66",66,66},
        };
    }

    @Test(dataProvider = "data")
    public void testMoveProvider(String input, int row, int column){
        MoveProvider moveProvider = new MoveProvider();
        MoveCoordinates coordinates = moveProvider.provideCoordinates(input);
        int rowFromCoordinate = coordinates.getRow();
        int columnFromCoordinate = coordinates.getColumn();
        Assert.assertEquals(rowFromCoordinate,row);
        Assert.assertEquals(columnFromCoordinate,column);
    }

    @Test
    void testCurrentPlayerSetting(){
        MoveProvider moveProvider = new MoveProvider();
        moveProvider.setCurrentPlayer(new Player("Player1",Figure.CIRCLE));
        Assert.assertNotNull(moveProvider.getPlayer());
    }
}
