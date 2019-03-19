package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Player {
    private String name;
    private Figure figure;
    private int score;

    Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    Figure getFigure() {
        return figure;
    }

    String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
