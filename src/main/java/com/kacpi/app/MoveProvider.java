package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveProvider {

    MoveCoordinates provideCoordinates(String move){
        Integer row = 0;
        Integer column = 0;
        String[] inputs = move.split(",");
            row = Integer.parseInt(String.valueOf(inputs[0]));
            column = Integer.parseInt(String.valueOf(inputs[1]));
        return new MoveCoordinates(row,column, Figure.CIRCLE);
    }
}

   // MoveCoordinates provideCoordinates(String move) {
//        Boolean correctCoordinates = false;
//        Integer row = 0;
//        Integer column = 0;
//        while (!correctCoordinates) {
//            System.out.println("Pr");
//            String input = inputProvider.getMove();
//                row = Integer.parseInt(String.valueOf(input.charAt(0)));
//                column = Integer.parseInt(String.valueOf(input.charAt(2)));
//                correctCoordinates = true;
//        }
//
//        return new MoveCoordinates(row, column, currentFigure);
//    }
//
//    public void setCurrentFigure(Figure currentFigure) {
//        this.currentFigure = currentFigure;
//    }
//}