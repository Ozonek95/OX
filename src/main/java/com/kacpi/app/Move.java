package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
public class Move {
    private MoveCoordinates coordinates;
    Move(MoveCoordinates coordinates) {
        this.coordinates=coordinates;
    }

    public MoveCoordinates getCoordinates() {
        return coordinates;
    }
}
