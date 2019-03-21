package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class WinnerChecker {
    private Board board;

    WinnerChecker(Board board) {

        this.board = board;
    }

    /**
     * @param moveCoordinates last move, base on it class checks if move was winning.
     * @return true if move won the round.
     */
    boolean checkIfAnyoneWon(MoveCoordinates moveCoordinates) {
        if (checkIfAnyoneWonRows(moveCoordinates)) return true;
        if (checkIfAnyoneWonColumns(moveCoordinates)) return true;
        if (checkIfAnyoneWonDiagonals(moveCoordinates)) return true;
        return checkIfAnyoneWonDiagonalsOtherSide(moveCoordinates);
    }


    /**
     * All of below methods check if move is winning move based on its coordinate, and game winning conditions. If any returns true, move was winning.
     *
     */
    private boolean checkIfAnyoneWonRows(MoveCoordinates moveCoordinates) {
        int fieldsToCheck = (board.getPatternToWinLength() * 2) - 1;

        int row = moveCoordinates.getRow();
        int column = moveCoordinates.getColumn();
        Figure figureToCheck = moveCoordinates.getFigure();
        Figure currentFigure = null;
        int startIndex = (row - fieldsToCheck / 2);
        int endIndex = (row + fieldsToCheck / 2);
        int innerCounter = 0;
        while (currentFigure == null) {
            try {
                currentFigure = board.getField(startIndex + innerCounter, column).getState();
            } catch (IndexOutOfBoundsException exception) {
                innerCounter++;
            }
        }
        int counter = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            try {
                if (board.getField(i, column).getState().equals(figureToCheck)) {
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

    private boolean checkIfAnyoneWonColumns(MoveCoordinates moveCoordinates) {
        int fieldsToCheck = (board.getPatternToWinLength() * 2) - 1;
        int row = moveCoordinates.getRow();
        int column = moveCoordinates.getColumn();
        Figure figureToCheck = moveCoordinates.getFigure();
        Figure currentFigure = null;
        int startIndex = (column - fieldsToCheck / 2);
        int endIndex = (column + fieldsToCheck / 2);
        int innerCounter = 0;
        while (currentFigure == null) {
            try {
                currentFigure = board.getField(row, startIndex + innerCounter).getState();
            } catch (IndexOutOfBoundsException exception) {
                innerCounter++;
            }
        }
        int counter = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            try {
                if (board.getField(row, i).getState().equals(figureToCheck)) {
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

    private boolean checkIfAnyoneWonDiagonals(MoveCoordinates moveCoordinates) {
        int fieldsToCheck = (board.getPatternToWinLength() * 2) - 1;
        int row = moveCoordinates.getRow();
        int column = moveCoordinates.getColumn();
        Figure figureToCheck = moveCoordinates.getFigure();
        Figure currentFigure = null;
        int startIndexColumn = (column - fieldsToCheck / 2);
        int startIndexRow = (row - fieldsToCheck / 2);
        int innerCounter = 0;
        while (currentFigure == null) {
            try {
                currentFigure = board.getField(startIndexRow + innerCounter, startIndexColumn + innerCounter).getState();
            } catch (IndexOutOfBoundsException exception) {
                innerCounter++;
            }
        }
        int counter = 0;
        int iterations = 0;
        while (iterations < fieldsToCheck) {
            try {
                if (board.getField(startIndexRow + iterations, startIndexColumn + iterations).getState().equals(figureToCheck)) {
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
            iterations++;
        }
        return false;
    }

    private boolean checkIfAnyoneWonDiagonalsOtherSide(MoveCoordinates moveCoordinates) {
        int fieldsToCheck = (board.getPatternToWinLength() * 2) - 1;
        int row = moveCoordinates.getRow();
        int column = moveCoordinates.getColumn();
        Figure figureToCheck = moveCoordinates.getFigure();
        Figure currentFigure = null;
        int startIndexColumn = (column + fieldsToCheck / 2);
        int startIndexRow = (row - fieldsToCheck / 2);
        int innerCounter = 0;
        while (currentFigure == null) {
            try {
                currentFigure = board.getField(startIndexRow + innerCounter, startIndexColumn - innerCounter).getState();
            } catch (IndexOutOfBoundsException exception) {
                innerCounter++;
            }
        }
        int counter = 0;
        int iterations = 0;
        while (iterations < fieldsToCheck) {
            try {
                if (board.getField(startIndexRow + iterations, startIndexColumn - iterations).getState().equals(figureToCheck)) {
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
            iterations++;
        }
        return false;
    }
}
