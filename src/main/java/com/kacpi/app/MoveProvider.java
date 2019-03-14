package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class MoveProvider {
    private String move;

    MoveProvider(String move){
        this.move=move;
    }

    MoveCoordinates provideCoordinates(){
        Integer row = 0;
        Integer column = 0;
        String[] inputs = move.split(",");
        try {
                row = Integer.parseInt(String.valueOf(inputs[0]));
                column = Integer.parseInt(String.valueOf(inputs[1]));
            } catch (NumberFormatException e){
                //TO DO PROVIDE MESSAGE
            }
        return new MoveCoordinates(row,column);
    }
}


//Wersja z dependencją MessageProvidera

//    private InputProvider inputProvider;


//    MoveProvider(InputProvider inputProvider) {
//        this.inputProvider = inputProvider;
//    }

//    MoveCoordinates provideCoordinates() {
//        Boolean correctCoordinates = false;
//        Integer row = 0;
//        Integer column = 0;
//        while (!correctCoordinates){
//            String input = inputProvider.getMove();
//            try {
//                row = Integer.parseInt(String.valueOf(input.charAt(0)));
//                column = Integer.parseInt(String.valueOf(input.charAt(2)));
//                correctCoordinates = true;
//            } catch (NumberFormatException e){
//                //TO DO PROVIDE MESSAGE
//            }
//        }
//
//        return new MoveCoordinates(row,column);
//    }
