package com.kacpi.app;
/**
 * @author Kacper Staszek
 */
class BoardUpdater {
    private Board board;

    BoardUpdater(Board board) {
        this.board = board;
    }

    void updateBoard(MoveCoordinates moveCoordinates) {
        int column = moveCoordinates.getColumn();
        int row = moveCoordinates.getRow();
        Figure figure = moveCoordinates.getFigure();
        board.setField(row,column,figure);
    }
}
