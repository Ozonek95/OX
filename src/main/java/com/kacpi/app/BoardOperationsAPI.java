package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class BoardOperationsAPI {
    private Board board;
    private BoardPrinter boardPrinter;
    private BoardUpdater boardUpdater;
    private WinnerChecker winnerChecker;

    BoardOperationsAPI(Settings settings) {
        board = new Board(settings);
        this.boardPrinter = new BoardPrinter(board);
        this.boardUpdater = new BoardUpdater(board);
        this.winnerChecker = new WinnerChecker(board);
    }

    boolean makeMove(MoveCoordinates moveCoordinates){
        boardUpdater.updateBoard(moveCoordinates);
        boardPrinter.printBoard();
        return winnerChecker.checkIfAnyoneWon(moveCoordinates);
    }

    Board getBoard(){
        return board;
    }

    int boardSize(){
        return board.getFieldsNumber();
    }

    void clear() {
        board.clear();
    }

    void printBoard(){
        boardPrinter.printBoard();
    }
}
