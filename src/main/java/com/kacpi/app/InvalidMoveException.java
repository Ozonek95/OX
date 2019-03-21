package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class InvalidMoveException extends Exception {
    InvalidMoveException(String message) {
        super(message);
    }
}
