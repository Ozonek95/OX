package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Player {
    private Figure figure;

    public Player(Figure figure) {
        this.figure = figure;
    }

    Figure getFigure() {
        return figure;
    }

}
