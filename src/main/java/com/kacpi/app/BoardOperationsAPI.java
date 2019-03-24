package com.kacpi.app;

/**
 * @author Kacper Staszek
 *
 * created to operate easier on Board related operations.
 */
class BoardOperationsAPI {
    private Board board;
    private BoardPrinter boardPrinter;
    private BoardUpdater boardUpdater;
    private WinnerChecker winnerChecker;
    /**
     * @param settings is required, to create board with correct parameters. Then it is injected to other objects.
     */
    BoardOperationsAPI(Settings settings) {
        board = new Board(settings);
        this.boardPrinter = new BoardPrinter(board);
        this.boardUpdater = new BoardUpdater(board);
        this.winnerChecker = new WinnerChecker(board);
    }
    /**
     * @param moveCoordinates based on coordinates change board state, also print board to players after move.
     * @return depend on that if given move was winning move, or not.
     */
    boolean makeMove(MoveCoordinates moveCoordinates){
        boardUpdater.updateBoard(moveCoordinates);
        boardPrinter.printBoard();
        return winnerChecker.checkIfAnyoneWon(moveCoordinates);
    }

    Board getBoard(){
        return board;
    }
    /**
     * @return Board fields number, which is need to check if draw happened.
     */
    int boardSize(){
        return board.getFieldsNumber();
    }
    /**
     * Makes all board fields Figure.EMPTY
     */
    void clear() {
        board.clear();
    }

    void printBoard(){
        boardPrinter.printBoard();
    }
}
