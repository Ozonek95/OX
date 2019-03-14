package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveValidator {
    boolean validateMove(Move move, Player player, Board board) {
            Figure figure = player.getFigure();
            MoveCoordinates coordinates = move.getCoordinates();
            int row = coordinates.getRow();
            int column = coordinates.getColumn();
            if(row>=board.getRows()||row<0||column>=board.getColumns()||column<0){
                return false;
            }
        return checkIfFiguresAreNotSame(board, figure, coordinates);
    }

    private boolean checkIfFiguresAreNotSame(Board board, Figure figure, MoveCoordinates coordinates) {
        Figure fieldState = board.getField(coordinates.getRow(),coordinates.getColumn()).getState();
        return !figure.equals(fieldState);
    }
}
