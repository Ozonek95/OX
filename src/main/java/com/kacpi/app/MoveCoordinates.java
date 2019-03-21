package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveCoordinates {
    private final Integer row;
    private final Integer column;
    private final Figure figure;

    MoveCoordinates(Integer row, Integer column,Figure figure) {
        this.row = row;
        this.column = column;
        this.figure=figure;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    public Figure getFigure() {
        return figure;
    }
}
