package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveCoordinates {
    private final Integer row;
    private final Integer column;

    MoveCoordinates(Integer row, Integer column) {

        this.row = row;
        this.column = column;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }
}
