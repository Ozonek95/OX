package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveValidator {
    boolean validateMove(MoveCoordinates move, Board board) {
            Figure figure = move.getFigure();
            int row = move.getRow();
            int column = move.getColumn();
            if(row>=board.getRows()||row<0||column>=board.getColumns()||column<0){
                return false;
            }
        return checkIfFiguresAreNotSame(board, figure, move);
    }

    private boolean checkIfFiguresAreNotSame(Board board, Figure figure, MoveCoordinates coordinates) {
        Figure fieldState = board.getField(coordinates.getRow(),coordinates.getColumn()).getState();
        return !figure.equals(fieldState);
    }
}
