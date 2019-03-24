package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class GameInformation {
    private Settings settings;
    private Player currentPlayer;
    private Boolean someoneWinGame = false;
    private int moves = 0;
    private int rounds = 0;

    /**
     * @param settings need to have info about players
     *                 hold all need info about game current state.
     */
    GameInformation(Settings settings) {
        this.settings = settings;
        this.currentPlayer = settings.getPlayers().get(0);
    }

    boolean checkIfSomeoneWonGame() {
        return someoneWinGame;
    }

    int roundsPlayed() {
        return rounds;
    }

    String getWinner() {
        if (settings.getPlayers().get(0).getScore() > settings.getPlayers().get(1).getScore()) {
            return settings.getPlayers().get(0).getName();
        } else if(settings.getPlayers().get(0).getScore() < settings.getPlayers().get(1).getScore()){
            return settings.getPlayers().get(1).getName();
        } else return "DRAW!";
    }

    String getPlayerName() {
        return currentPlayer.getName();
    }

    void addScore() {
        currentPlayer.addScore(3);
    }

     void increaseMove() {
        moves++;
    }

    int getScore() {
        return currentPlayer.getScore();
    }

    void setWinner() {
        someoneWinGame =true;
    }

    int getMovesNumber() {
        return moves;
    }

    void changePlayer() {
        Player playerTemp = settings.getPlayers().get(0);
        settings.getPlayers().set(0,settings.getPlayers().get(1));
        settings.getPlayers().set(1,playerTemp);
        currentPlayer = settings.getPlayers().get(0);
    }

    void draw() {
        settings.getPlayers().get(0).addScore(1);
        settings.getPlayers().get(1).addScore(1);
        rounds++;
        moves=0;
    }

    void nextRound() {
        rounds++;
    }

    void moveToZero() {
        moves=0;
    }
}
