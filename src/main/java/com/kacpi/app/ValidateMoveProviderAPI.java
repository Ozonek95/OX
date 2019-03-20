package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class ValidateMoveProviderAPI {
    private Settings settings;
    private InputProvider inputProvider;
    private MoveProvider moveProvider;
    private MoveValidator moveValidator;

    ValidateMoveProviderAPI(InputProvider inputProvider, MoveValidator moveValidator, Settings settings) {
        this.inputProvider = inputProvider;
        this.moveProvider = new MoveProvider();
        this.settings = settings;
        this.moveValidator = moveValidator;
    }


    MoveCoordinates getValidMove(){
        boolean validMove = false;
        MoveCoordinates moveCoordinates = null;
        while (!validMove){
            String move = inputProvider.getMove();
            try {
                moveCoordinates = moveProvider.provideCoordinates(move);
                moveValidator.validateMove(moveCoordinates);
                validMove=true;
            } catch (NumberFormatException e){
                System.err.print("Bad move coordinates");
            } catch (InvalidMoveException e) {
                System.err.print(e.getMessage());
            }
        }
        moveProvider.setCurrentPlayer(settings.getPlayers().get(1));
        return moveCoordinates;
    }

}
