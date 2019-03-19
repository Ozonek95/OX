package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
public class Main {
    public static void main(String[] args) {
        Board board = new Board(5,10);
        BoardPrinter printer = new BoardPrinter(board);
        board.setField(0,0,Figure.CIRCLE);
        board.setField(0,1,Figure.CIRCLE);
        board.setField(0,2,Figure.CROSS);
        board.setField(3,2,Figure.CROSS);
        board.setField(0,9,Figure.CROSS);
        board.setField(4,9,Figure.CROSS);
        printer.printBoard();

    }


}
