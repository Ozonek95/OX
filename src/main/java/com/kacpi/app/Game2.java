package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
public class Game2 {
    private BoardOperationsAPI boardOperationsAPI;
    private Settings settings;
    private ValidateMoveProviderAPI validateMoveProviderAPI;
    private MessageProviderBasedOnLanguage messageProvider;
    private GameInformation gameInformation;

    Game2(Settings settings, MessageProviderBasedOnLanguage messageProviderBasedOnLanguage) {
        this.settings = settings;
        this.boardOperationsAPI = new BoardOperationsAPI(settings);
        this.messageProvider = new MessageProviderBasedOnLanguage();
        this.validateMoveProviderAPI = new ValidateMoveProviderAPI(new InputKeyboardProvider(), new MoveValidator(boardOperationsAPI.getBoard()));
        messageProvider = messageProviderBasedOnLanguage;
        validateMoveProviderAPI.setMessageProviderBasedOnLanguage(messageProvider);
    }

    void playMatch() {
        while (!gameInformation.checkIfHaveWinner() || gameInformation.roundsPlayed() < 3) {
            playSmallMatch();
        }
        System.out.println("Winner is "+gameInformation.getWinner());
    }

    private String getWinner() {
        if(settings.getPlayers().get(0).getScore()>settings.getPlayers().get(1).getScore()){
            return settings.getPlayers().get(0).getName();
        } else {
            return settings.getPlayers().get(1).getName();
        }
    }

    private void playSmallMatch() {
        boolean haveSmallMatchWinner = false;
        while (!haveSmallMatchWinner) {
            System.out.println(messageProvider.provideMessage("provideMove")+" "+ currentPlayer.getName());
            MoveCoordinates validMove = validateMoveProviderAPI.getValidMove();
            boolean winner = boardOperationsAPI.makeMove(validMove);
            if (winner) {
                currentPlayer.addScore(3);
                System.out.println(currentPlayer.getName() + " Won! score is "+settings.getPlayers().get(0).getScore()+" vs "+settings.getPlayers().get(1).getScore());
                gameInformation.increaseMove();

                haveSmallMatchWinner = true;
                if (gameInformation.getScore() == 6) {
                    gameInformation.setWinner(true);
                }
            }
           gameInformation.increaseMove();
            if (gameInformation.getMovesNumber() == boardOperationsAPI.boardSize()) {
                draw();
            }
            settings.changePlayers();
            gameInformation.changePlayer();
        }
        boardOperationsAPI.clear();
    }
    private void draw() {
        gameInformation.draw();
        gameInformation.nextRound();
        System.out.println("Draw");
    }
}
}
