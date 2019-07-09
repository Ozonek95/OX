package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class WinnerChecker {
    private final Board board;
    private final int fieldsToCheck;

    WinnerChecker(Board board) {
        this.board = board;
        fieldsToCheck = (board.getPatternToWinLength() * 2) - 1;
    }
    /**
     * @param moveCoordinates last move, base on it class checks if move was winning.
     * @return true if move won the round.
     */
    boolean checkIfAnyoneWon(MoveCoordinates moveCoordinates) {
        int row = moveCoordinates.getRow();
        int column = moveCoordinates.getColumn();
        Figure figure = moveCoordinates.getFigure();
        if (checkIfAnyoneWonRows(row, column, figure)) return true;
        if (checkIfAnyoneWonColumns(row, column, figure)) return true;
        if (checkIfAnyoneWonDiagonals(row, column, figure)) return true;
        return checkIfAnyoneWonDiagonalsOtherSide(row, column, figure);
    }

    /**
     * All of below methods check if move is winning move based on its coordinate, and game winning conditions. If any returns true, move was winning.
     */
    private boolean checkIfAnyoneWonRows(int row, int column, Figure figure) {
        int startIndex = (row - fieldsToCheck / 2);
        int endIndex = (row + fieldsToCheck / 2);
        int counter = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            try {
                if (board.getField(i, column).getState().equals(figure)) {
                    counter++;
                    if (counter == board.getPatternToWinLength()) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                counter = 0;
            }
        }
        return false;
    }

    private boolean checkIfAnyoneWonColumns(int row, int column, Figure figure) {
        int startIndex = (column - fieldsToCheck / 2);
        int endIndex = (column + fieldsToCheck / 2);
        int counter = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            try {
                if (board.getField(row, i).getState().equals(figure)) {
                    counter++;
                    if (counter == board.getPatternToWinLength()) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                counter = 0;
            }
        }
        return false;
    }

    private boolean checkIfAnyoneWonDiagonals(int row, int column, Figure figure) {
        int startIndexColumn = (column - fieldsToCheck / 2);
        int startIndexRow = (row - fieldsToCheck / 2);
        int counter = 0;
        for (int i = 0; i < fieldsToCheck; i++) {
            try {
                if (board.getField(startIndexRow + i, startIndexColumn + i).getState().equals(figure)) {
                    counter++;
                    if (counter == board.getPatternToWinLength()) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                counter = 0;
            }
        }
        return false;
    }
    
    private boolean checkIfAnyoneWonDiagonalsOtherSide(int row, int column, Figure figure) {
        int startIndexColumn = (column + fieldsToCheck / 2);
        int startIndexRow = (row - fieldsToCheck / 2);
        int counter = 0;
        for (int i = 0; i < fieldsToCheck; i++) {
            try {
                if (board.getField(startIndexRow + i, startIndexColumn - i).getState().equals(figure)) {
                    counter++;
                    if (counter == board.getPatternToWinLength()) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                counter = 0;
            }
        }
        return false;
    }
}
