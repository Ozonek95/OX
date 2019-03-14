package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Settings {
    private final int rows;
    private final int columns;
    private final int patternToWinLength;

    Settings(int rows, int columns, int patternToWinLength) {
        this.rows = rows;
        this.columns = columns;
        this.patternToWinLength = patternToWinLength;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getPatternToWinLength() {
        return patternToWinLength;
    }
}
