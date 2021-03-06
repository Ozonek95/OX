package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveProvider {

    private Figure currentFigure = Figure.CROSS;

    MoveCoordinates provideCoordinates(String move) {
        int row;
        int column;
        String[] inputs = move.split(",");
        if(inputs.length<=1){
            throw new IllegalArgumentException("Incorrect coordinates");
        }
        row = Integer.parseInt(String.valueOf(inputs[0]));
        column = Integer.parseInt(String.valueOf(inputs[1]));
        return new MoveCoordinates(row, column, currentFigure);
    }

     void changeFigure() {
        if (currentFigure.equals(Figure.CIRCLE)) {
            currentFigure = Figure.CROSS;
        } else currentFigure = Figure.CIRCLE;
    }
}
