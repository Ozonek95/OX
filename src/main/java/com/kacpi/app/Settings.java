package com.kacpi.app;

import java.util.ArrayList;
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

    Settings(int rows, int columns, int patternToWinLength) {
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

    String getPlayerName(int index){
        return players.get(index).getName();
    }
}
