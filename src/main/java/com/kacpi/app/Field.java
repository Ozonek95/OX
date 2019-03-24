package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Field {
    private Figure state;

    Field() {
        this.state = Figure.EMPTY;
    }

    Figure getState() {
        return state;
    }

    void setState(Figure figure) {
        this.state=figure;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
