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

    /**
     * @param settings are used to game logic and creation.
     * @param messageProviderBasedOnLanguage provides proper messages in chosen language.
     * @param inputProvider provide possibility to interact with users, also helpful in tests, if we create our own scanner inputs.
     * @param gameInformation holds state of the game such as number of rounds, moves, and players.
     */
    Game(Settings settings, MessageProviderBasedOnLanguage messageProviderBasedOnLanguage, InputProvider inputProvider, GameInformation gameInformation) {
        this.settings = settings;
        this.boardOperationsAPI = new BoardOperationsAPI(settings);
        this.messageProvider = new MessageProviderBasedOnLanguage();
        this.validateMoveProviderAPI = new ValidateMoveProviderAPI(inputProvider, new MoveValidator(boardOperationsAPI.getBoard()));
        messageProvider = messageProviderBasedOnLanguage;
        validateMoveProviderAPI.setMessageProviderBasedOnLanguage(messageProvider);
        this.gameInformation=gameInformation;
    }

    /**
     * main loop of program. Keep working till someone score 6 points, 3 rounds were played, or somebody quit game.
     */
    void playMatch() {
        while (!gameInformation.checkIfHaveWinner() && gameInformation.roundsPlayed() < 3) {
            playSmallMatch();
        }
        String winner = gameInformation.getWinner();
        if(winner.equals("DRAW!")){
            System.out.println(messageProvider.provideMessage("draw"));
        }else {
            System.out.println(messageProvider.provideMessage("winner")+" "+winner+"!");
        }
    }

    /**
     * Single round loop. Works as long as somebody win current round, or there is a draw.
     */
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
                printRoundWinner();
                showGameScore();
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
                System.out.println(messageProvider.provideMessage("drawInRound"));
                showGameScore();
                haveSmallMatchWinner=true;
            }
            gameInformation.changePlayer();
        }
        boardOperationsAPI.clear();
    }

    private void printRoundWinner(){
        System.out.println(messageProvider.provideMessage("roundWinner")+" "+gameInformation.getPlayerName());
    }
    /**
     * Provides information about current score result.
     */

    private void showGameScore() {
        System.out.println(messageProvider.provideMessage("score") + settings.getPlayers().get(0).getScore()
                + " vs " + settings.getPlayers().get(1).getScore());
    }

    GameInformation getGameInformation() {
        return gameInformation;
    }
}

