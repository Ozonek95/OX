package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Player {
    private String name;
    private int score;

    Player(String name, Figure circle) {
        this.name = name;
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

    void setName(String name) {
        this.name=name;
    }
}
