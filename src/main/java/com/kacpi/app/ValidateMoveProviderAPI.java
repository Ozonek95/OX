package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class ValidateMoveProviderAPI {
    private InputProvider inputProvider;
    private MoveProvider moveProvider;
    private MoveValidator moveValidator;
    private MessageProviderBasedOnLanguage messageProviderBasedOnLanguage;

    /**
     * @param inputProvider provide possibility to interact with user. He can provide his moves thanks to that.
     * @param moveValidator logic that looks, if provided move is valid.
     *
     * Combines classes that are responsible for moves on game board.
     */
    ValidateMoveProviderAPI(InputProvider inputProvider, MoveValidator moveValidator) {
        this.inputProvider = inputProvider;
        this.moveProvider = new MoveProvider();
        this.moveValidator = moveValidator;
    }


    /**
     * @return after validating, provides move to the game.
     */
    MoveCoordinates getValidMove() {
        boolean validMove = false;
        MoveCoordinates moveCoordinates = null;
        while (!validMove) {
            String move = inputProvider.getInput();
            if (move.equals(messageProviderBasedOnLanguage.provideMessage("quit"))) {
                return null;
            } else {
                try {
                    moveCoordinates = moveProvider.provideCoordinates(move);
                    moveValidator.validateMove(moveCoordinates);
                    validMove = true;
                    moveProvider.changeFigure();
                } catch (InvalidMoveException | IllegalArgumentException e) {
                    System.err.println(messageProviderBasedOnLanguage.provideMessage("badMove"));
                }
            }
        }
        return moveCoordinates;
    }

    void setMessageProviderBasedOnLanguage(MessageProviderBasedOnLanguage messageProviderBasedOnLanguage) {
        this.messageProviderBasedOnLanguage = messageProviderBasedOnLanguage;
    }
}
