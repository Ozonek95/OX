package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Game {
    private Board board;
    private Settings settings;
    private Player currentPlayer;
    private BoardPrinter boardPrinter;
    private BoardUpdater boardUpdater;
    private WinnerChecker winnerChecker;
    private ValidateMoveProviderAPI validateMoveProviderAPI;
    private MessageProviderBasedOnLanguage messageProvider;
    private Boolean haveWinner = false;
    private int moves = 0;
    private int rounds = 0;

    Game(Settings settings, MessageProviderBasedOnLanguage messageProviderBasedOnLanguage) {
        this.settings = settings;
        this.board = new Board(settings);
        this.boardPrinter = new BoardPrinter(board);
        this.boardUpdater = new BoardUpdater(board);
        this.winnerChecker = new WinnerChecker(board);
        changeCurrentPlayer(settings);
        this.messageProvider = new MessageProviderBasedOnLanguage();
        this.validateMoveProviderAPI = new ValidateMoveProviderAPI(new InputKeyboardProvider(), new MoveValidator(board));
        messageProvider = messageProviderBasedOnLanguage;
        validateMoveProviderAPI.setMessageProviderBasedOnLanguage(messageProvider);
    }

    void playMatch() {
        while (!haveWinner || rounds < 3) {
            playSmallMatch();
        }
        System.out.println("Winner is "+getWinner());
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
            boardPrinter.printBoard();
            System.out.println(messageProvider.provideMessage("provideMove")+" "+ currentPlayer.getName());
            MoveCoordinates validMove = validateMoveProviderAPI.getValidMove();
            boardUpdater.updateBoard(validMove);
            if (winnerChecker.checkIfAnyoneWon(validMove)) {
                currentPlayer.addScore(3);
                System.out.println(currentPlayer.getName() + " Won! score is "+settings.getPlayers().get(0).getScore()+" vs "+settings.getPlayers().get(1).getScore());
                rounds++;

                haveSmallMatchWinner = true;
                if (currentPlayer.getScore() == 6) {
                    haveWinner = true;
                }
            }
            moves++;
            if (moves == board.getFieldsNumber()) {
                draw();
            }
            settings.changePlayers();
            changeCurrentPlayer(settings);
        }
        board.clear();
    }

    private void changeCurrentPlayer(Settings settings) {
        currentPlayer = settings.getPlayers().get(0);
    }

    private void draw() {
       settings.getPlayers().get(0).addScore(1);
        settings.getPlayers().get(1).addScore(1);
        rounds++;
        System.out.println("Draw");
    }
}
