package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class WinnerChecker {
    boolean checkIfAnyoneWon(Board board) {
        int patternLength = board.getPatternToWinLength();
        int rows = board.getRows();
        int columns = board.getColumns();
        int counter = 0;
        Figure currentFigure;
        for (int i=0;i<rows;i++){
            currentFigure = null;
            for (int j=0;j<columns;j++){
                if(currentFigure==(null)){
                    currentFigure=board.getField(i,j).getState();
                }
                if(board.getField(i,j).getState().equals(currentFigure) && !currentFigure.equals(Figure.EMPTY)){
                    counter++;
                    if(counter==patternLength){
                        return true;
                    }
                } else {
                    currentFigure=board.getField(i,j).getState();
                    counter=0;
                }
            }
        }

        counter=0;
        for (int i=0;i<columns;i++){
            currentFigure = null;
            for (int j=0;j<rows;j++){
                if(currentFigure==(null)){
                    currentFigure=board.getField(i,j).getState();
                }
                if(board.getField(i,j).getState().equals(currentFigure) && !currentFigure.equals(Figure.EMPTY)){
                    counter++;
                    if(counter==patternLength){
                        return true;
                    }
                } else {
                    currentFigure=board.getField(i,j).getState();
                    counter=0;
                }
            }
        }
        return false;
    }
}
