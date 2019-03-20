package com.kacpi.app;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kacper Staszek
 */
public class Game {
    private Board board;
    private Settings settings;
    //private List<Player> players;
    private Player currentPlayer;
    private BoardPrinter boardPrinter;
    private BoardUpdater boardUpdater;
    private WinnerChecker winnerChecker;
    private ValidateMoveProviderAPI validateMoveProviderAPI;
    private Boolean haveWinner =  false;

    Game(Settings settings){
        this.settings = settings;
        this.board = new Board(settings);
        this.boardPrinter = new BoardPrinter(board);
        this.boardUpdater = new BoardUpdater(board);
        this.winnerChecker = new WinnerChecker(board);
        // this.players = settings.getPlayers();
        this.currentPlayer = settings.getPlayers().get(0);
        this.validateMoveProviderAPI = new ValidateMoveProviderAPI(new InputKeyboardProvider(),new MoveValidator(board),settings);
    }

    public void playMatch(){
        while (!haveWinner){
            playSmallMatch();
        }
    }

    void playSmallMatch(){
        boolean haveSmallMatchWinner = false;
        while (!haveSmallMatchWinner){
            boardPrinter.printBoard();
            System.out.println("Provide move please, "+currentPlayer.getName());
            MoveCoordinates validMove = validateMoveProviderAPI.getValidMove();
            boardUpdater.updateBoard(validMove);
            if(winnerChecker.checkIfAnyoneWon(validMove)){
                System.out.println(currentPlayer.getName()+" Won!");
                currentPlayer.addScore(3);
                haveSmallMatchWinner=true;
                if(currentPlayer.getScore()==6){
                    haveWinner=true;
                }
            }
            settings.changePlayers();
            currentPlayer = settings.getPlayers().get(0);
        }
    }
}
