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

    int getScore() {
        return score;
    }

    void addScore(int score) {
        this.score+=score;
    }
}
