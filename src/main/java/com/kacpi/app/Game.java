package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Game {
    private BoardOperationsAPI boardOperationsAPI;
    private Settings settings;
    private ValidateMoveProviderAPI validateMoveProviderAPI;
    private MessageProviderBasedOnLanguage messageProvider;
    private GameInformation gameInformation;

    Game(Settings settings, MessageProviderBasedOnLanguage messageProviderBasedOnLanguage, InputProvider inputProvider, GameInformation gameInformation) {
        this.settings = settings;
        this.boardOperationsAPI = new BoardOperationsAPI(settings);
        this.messageProvider = new MessageProviderBasedOnLanguage();
        this.validateMoveProviderAPI = new ValidateMoveProviderAPI(inputProvider, new MoveValidator(boardOperationsAPI.getBoard()));
        messageProvider = messageProviderBasedOnLanguage;
        validateMoveProviderAPI.setMessageProviderBasedOnLanguage(messageProvider);
        this.gameInformation=gameInformation;
    }

    void playMatch() {
        while (!gameInformation.checkIfHaveWinner() && gameInformation.roundsPlayed() < 3) {
            playSmallMatch();
        }
        String winner = gameInformation.getWinner();
        if(winner.equals("DRAW")){
            System.out.println(messageProvider.provideMessage("draw"));
        }else {
            System.out.println(messageProvider.provideMessage("winner")+" "+winner+"!");
        }
    }

    private void playSmallMatch() {
        boolean haveSmallMatchWinner = false;
        boardOperationsAPI.printBoard();
        while (!haveSmallMatchWinner) {
            System.out.println(messageProvider.provideMessage("provideMove") + " " + gameInformation.getPlayerName());
            MoveCoordinates validMove = validateMoveProviderAPI.getValidMove();
            if(validMove==null){
                System.out.println(messageProvider.provideMessage("goodbye"));
                System.exit(0);
            }
            boolean winner = boardOperationsAPI.makeMove(validMove);
            if (winner) {
                gameInformation.addScore(3);
                System.out.println(gameInformation.getPlayerName() + " Won! score is " + settings.getPlayers().get(0).getScore() + " vs " + settings.getPlayers().get(1).getScore());
                gameInformation.nextRound();
                gameInformation.moveToZero();

                haveSmallMatchWinner = true;
                if (gameInformation.getScore() == 6) {
                    gameInformation.setWinner(true);
                }
            }
            gameInformation.increaseMove();
            if (gameInformation.getMovesNumber() == boardOperationsAPI.boardSize()) {
                gameInformation.draw();
                haveSmallMatchWinner=true;
            }
            gameInformation.changePlayer();
        }
        boardOperationsAPI.clear();
    }
    GameInformation getGameInformation() {
        return gameInformation;
    }
}

