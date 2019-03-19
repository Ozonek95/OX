package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveValidator {
    private Board board;

    public MoveValidator(Board board) {
        this.board = board;
    }

    boolean validateMove(MoveCoordinates move) {
            Figure figure = move.getFigure();
            int row = move.getRow();
            int column = move.getColumn();
            if(row>=board.getRows()||row<0||column>=board.getColumns()||column<0){
                return false;
            }
        return checkIfFiguresAreNotSame(figure, move);
    }

    private boolean checkIfFiguresAreNotSame(Figure figure, MoveCoordinates coordinates) {
        Figure fieldState = board.getField(coordinates.getRow(),coordinates.getColumn()).getState();
        return fieldState == Figure.EMPTY;
    }
}
