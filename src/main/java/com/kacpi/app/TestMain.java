package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class TestMain {
    public static void main(String[] args) {
        WinningConditionsGenerator generator = new WinningConditionsGenerator();
        generator.fillMaps(5,6);
        generator.winningConditionDiagonalSmallTraingleLeftTopRightBottom(6,5,3);

    }
}
