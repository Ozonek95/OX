package com.kacpi.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author Kacper Staszek
 */
class BoardPrinter {
    private Board board;
    private final PrintStream console;
    private PrintStream currentPrinter;



    BoardPrinter(Board board) {
        this.board = board;
        this.console = System.out;
    }

    void changePrinterToConsole(){
        System.setOut(console);
        currentPrinter = console;
    }

    void changePrinterToFile(String fileName){
        try {
            PrintStream writer = new PrintStream(new File(fileName));
            currentPrinter = writer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void printBoard() {
        for (int i = 0; i < board.getRows(); i++) {
            if(i==0){
                for (int i1=0;i1<board.getColumns()+1;i1++){
                    if(i1>0) {
                        System.out.print("  " + (i1 - 1) + " |");
                    }
                    else {
                        System.out.print("     |");
                    }
                }
                System.out.println();
            }
            for (int j = 0; j < board.getColumns()+1; j++) {

                if (j == board.getColumns()) {
                    System.out.print("+");
                    System.out.print("----");
                    System.out.print("+");

                } else {
                    System.out.print("+");
                    System.out.print("----");
                }
            }
            System.out.println();

            StringBuilder toPaste = new StringBuilder();
            for (int j=-1;j<board.getColumns();j++){

                if(j==-1){
                    System.out.print("   "+i+" ");
                }
                if(j>-1) {
                    if (board.getField(i, j).getState().equals(Figure.EMPTY)) {
                        toPaste.append("|    ");
                    } else if (board.getField(i, j).getState().equals(Figure.CIRCLE)) {
                        toPaste.append("|  O ");
                    } else {
                        toPaste.append("|  X ");
                    }

                    if (j == board.getColumns() - 1) {
                        toPaste.append("|");
                    }
                }
            }

            System.out.println(toPaste.toString());
        }
        for (int j = 0; j <= board.getColumns(); j++) {
            if (j == board.getColumns()) {
                System.out.print("+");
                System.out.print("----");
                System.out.print("+");

            } else {
                System.out.print("+");
                System.out.print("----");
            }
        }

        changePrinterToConsole();
    }
}
