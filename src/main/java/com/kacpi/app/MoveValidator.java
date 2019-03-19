package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveValidator {
    private Board board;

    MoveValidator(Board board) {
        this.board = board;
    }

    boolean validateMove(MoveCoordinates move) {
            int row = move.getRow();
            int column = move.getColumn();
            if(row>=board.getRows()||row<0||column>=board.getColumns()||column<0){
                return false;
            }
        return checkIfFieldIsEmpty(move);
    }

    private boolean checkIfFieldIsEmpty(MoveCoordinates coordinates) {
        Figure fieldState = board.getField(coordinates.getRow(),coordinates.getColumn()).getState();
        return fieldState == Figure.EMPTY;
    }
}
