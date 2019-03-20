package com.kacpi.app;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kacper Staszek
 */
class Settings {
    private final int rows;
    private final int columns;
    private final int patternToWinLength;
    private List<Player> players = Arrays.asList(new Player("Player1",Figure.CIRCLE),new Player("Player2",Figure.CROSS));

    Settings(int rows, int columns, int patternToWinLength) throws IllegalGameSettings {
        if(patternToWinLength>rows && patternToWinLength>columns){
            throw new IllegalGameSettings("Pattern to win can not be longer than number of rows and columns.");
        }
        this.rows = rows;
        this.columns = columns;
        this.patternToWinLength = patternToWinLength;
    }

    int getRows() {
        return rows;
    }

    int getColumns() {
        return columns;
    }

    int getPatternToWinLength() {
        return patternToWinLength;
    }

    List<Player> getPlayers() {
        return players;
    }

    void changePlayers() {
        Player playerTemp = players.get(0);
        players.set(0,players.get(1));
        players.set(1,playerTemp);
    }
}
