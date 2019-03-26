package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class TestMain {
    public static void main(String[] args) {
        WinningConditionsGenerator generator = new WinningConditionsGenerator();
        generator.fillMaps(6,5);
        generator.winningConditionDiagonalSmallTraingleLeftBottomRightTop(6,5,3);

    }
}
