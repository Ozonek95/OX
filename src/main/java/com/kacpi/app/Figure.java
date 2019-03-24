package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
public enum Figure {

    EMPTY("|    "), CIRCLE("|  O "),CROSS("|  X ");
    private String toString;
    Figure(String representation) {
        this.toString =representation;
    }

    @Override
    public String toString() {
        return toString;
    }
}
