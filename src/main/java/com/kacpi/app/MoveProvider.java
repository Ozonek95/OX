package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveProvider {

    private Player currentPlayer;

    MoveCoordinates provideCoordinates(String move){
        Integer row = 0;
        Integer column = 0;
        String[] inputs = move.split(",");
            row = Integer.parseInt(String.valueOf(inputs[0]));
            column = Integer.parseInt(String.valueOf(inputs[1]));
            if(currentPlayer==null){
                currentPlayer = new Player("Player1", Figure.CIRCLE);
            }
        return new MoveCoordinates(row,column, currentPlayer.getFigure());
    }

    void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    Player getPlayer(){
        return currentPlayer;
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