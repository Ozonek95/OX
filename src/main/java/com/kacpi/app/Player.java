package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Player {
    private String name;
    private Figure figure;

    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    Figure getFigure() {
        return figure;
    }
}
