package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveValidator {
    private Board board;

    MoveValidator(Board board) {
        this.board = board;
    }

    boolean validateMove(MoveCoordinates move) throws InvalidMoveException {
            Integer row = move.getRow();
            Integer column = move.getColumn();
            if(row>=board.getRows()||row<0||column>=board.getColumns()||column<0){
                throw new InvalidMoveException("Your move is out of bounds!");
            }
        return checkIfFieldIsEmpty(move);
    }

    private boolean checkIfFieldIsEmpty(MoveCoordinates coordinates) throws InvalidMoveException {
        Figure fieldState = board.getField(coordinates.getRow(),coordinates.getColumn()).getState();
        if(fieldState != Figure.EMPTY){
            throw new InvalidMoveException("This field is not empty.");
        }
        return true;
    }
}
