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
}
