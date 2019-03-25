package com.kacpi.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kacper Staszek
 */
class WinningConditionsGenerator {
    Map<Integer,int[]> mapOfRows = new HashMap<>();
    Map<Integer,int[]> mapOfColumns = new HashMap<>();
    void fillMaps(int rows, int columns){

        for (int i=0;i<rows;i++){
            mapOfRows.put(i,new int[]{i,rows-1-i});
        }
        for (int i=0;i<columns;i++){
            mapOfColumns.put(i,new int[]{i,columns-1-i});
        }
    }
    List<String> automaticGameDrawGenerator(int rows, int columns, int patternLength) {
        List<String> toReturn = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        //NIEPARZYSTE ROWS
        int counter = 0;
        boolean upSideDown = false;
        if (rows % 2 != 0) {
            for (int i = 0; i < columns; i += 2) {
                for (int j = 0; j < rows; j++) {
                    builder.append(j).append(",").append(i).append(System.lineSeparator());

                }
            }


            for (int i = 1; i < columns; i += 2) {
                for (int j = 0; j < rows; j++) {
                    builder.append(j).append(",").append(i).append(System.lineSeparator());
                }
            }
        }

//PARZYSTE ROWS
        else {
            for (int i = 0; i < columns; i++) {


                if (counter == 2) {
                    upSideDown = !upSideDown;
                    counter = 0;
                }
                if (!upSideDown) {
                    for (int j = 0; j < rows; j++) {
                        builder.append(j).append(",").append(i).append(System.lineSeparator());
                    }
                } else {
                    for (int j = rows-1; j >= 0; j--) {
                        builder.append(j).append(",").append(i).append(System.lineSeparator());
                    }
                }
               counter++;
            }
        }
       return toReturn;
    }

    List<String> winningRows(int rows, int columns, int patternLength) {
        List<String> movesToWin = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int possibleCombinations = rows - patternLength + 1;
        for (int k = 0; k < columns; k++) {
            for (int j = 0; j < possibleCombinations; j++) {
                builder.setLength(0);
                for (int i = j; i < patternLength + j; i++) {
                    if (k == columns - 1) {
                        builder.append(i).append(",").append(k).append(System.lineSeparator());
                        if (i != patternLength - 1 + j) {//WSTAWIA 3 KÓŁKA I DWA XY DLATEGO TU JEST - NIE WYWALAC
                            builder.append(i).append(",").append(0).append(System.lineSeparator());
                        }
                    } else {
                        builder.append(i).append(",").append(k).append(System.lineSeparator());
                        if (i != patternLength - 1 + j) {//WSTAWIA 3 KÓŁKA I DWA XY DLATEGO TU JEST - NIE WYWALAC
                            builder.append(i).append(",").append(k + 1).append(System.lineSeparator());
                        }
                    }
                }
                movesToWin.add(builder.toString());
            }
        }
        return movesToWin;
    }

    List<String> winningColumns(int rows, int columns, int patternLength) {
        List<String> movesToWin = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int possibleCombinations = columns - patternLength + 1;
        for (int k = 0; k < rows; k++) {
            for (int j = 0; j < possibleCombinations; j++) {
                builder.setLength(0);
                for (int i = j; i < patternLength + j; i++) {
                    if (k == rows - 1) {
                        builder.append(k).append(",").append(i).append(System.lineSeparator());
                        if (i != patternLength - 1 + j) {//WSTAWIA 3 KÓŁKA I DWA XY DLATEGO TU JEST - NIE WYWALAC
                            builder.append(0).append(",").append(i).append(System.lineSeparator());
                        }
                    } else {
                        builder.append(k).append(",").append(i).append(System.lineSeparator());
                        if (i != patternLength - 1 + j) {//WSTAWIA 3 KÓŁKA I DWA XY DLATEGO TU JEST - NIE WYWALAC
                            builder.append(k+1).append(",").append(i).append(System.lineSeparator());
                        }
                    }
                }
                movesToWin.add(builder.toString());
            }
        }
        return movesToWin;
    }
    List<String> winningRightDiagonal(int rows, int columns, int patternLength) {
        List<String> movesToWin = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int numberOfIterations = columns - (rows - 1);
        int possibleCombinations = rows - patternLength + 1;
        for (int k = 0; k < numberOfIterations; k++) {
            for (int p = 0; p < possibleCombinations; p++) {
                builder.setLength(0);
                for (int j = p; j < patternLength + p; j++) {
                    builder.append(j).append(",").append(k + j).append(System.lineSeparator());
                    if (j != patternLength - 1 + p) {
                        builder.append(j).append(",").append(k + j + 1).append(System.lineSeparator());
                    }

                }
                movesToWin.add(builder.toString());
            }
        }
        return movesToWin;
    }

    List<String> winningLeftDiagonal(int rows, int columns, int patternLength) {
        List<String> movesToWin = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int numberOfIterations = columns -(columns - (rows - 1));
        int possibleCombinations = rows - patternLength + 1;
        for (int k = columns - 1; k >= numberOfIterations; k--) {
            for (int p = 0; p < possibleCombinations; p++) {
                builder.setLength(0);
                for (int j = p; j < patternLength + p; j++) {
                    builder.append(j).append(",").append(k - j).append(System.lineSeparator());
                    if (j != patternLength - 1 + p) {
                        builder.append(j).append(",").append(k - j - 1).append(System.lineSeparator());
                    }

                }
                movesToWin.add(builder.toString());
            }
        }
        return movesToWin;
    }

    List<String> winningConditionDiagonalSmallTraingleLeftBottom(int rows, int columns, int patternLength){
        List<String> movesToWin = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        if(rows==patternLength){
            return null;
        } else {
            int iterations = rows-patternLength;
            for (int i=0;i<iterations;i++){
                for (int j = 1+i;j<=(rows-patternLength);j++){
                    builder.setLength(0);
                    for (int p=j;p<patternLength+j;p++){
                        builder.append(p).append(",").append(p-1-i).append(System.lineSeparator());
                        if(p<patternLength+j-1){
                            builder.append(p).append(",").append(p-i).append(System.lineSeparator());
                        }
                    }
                    movesToWin.add(builder.toString());
                }
            }
        }
        return movesToWin;
    }


    List<String> winningConditionDiagonalSmallTraingleLeftBottomRightTop(int rows, int columns, int patternLength){
        List<String> movesToWin = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        if(rows==patternLength){
            return null;
        } else {
            int iterations = rows-patternLength;
            for (int i=0;i<iterations;i++){
                for (int j = 1+i;j<=(rows-patternLength);j++){
                    builder.setLength(0);
                    builder2.setLength(0);
                    for (int p=j;p<patternLength+j;p++){
                        builder.append(p).append(",").append(p-1-i).append(System.lineSeparator());
                        builder2.append(mapOfRows.get(p)[1]).append(",").append(mapOfColumns.get(p-1-i)[1]).append(System.lineSeparator());
                        if(p<patternLength+j-1){
                            builder.append(p).append(",").append(p-i).append(System.lineSeparator());
                            builder2.append(mapOfRows.get(p)[1]).append(",").append(mapOfColumns.get(p-i)[1]).append(System.lineSeparator());
                        }
                    }
                    movesToWin.add(builder.toString());
                    movesToWin.add(builder2.toString());
                }
            }
        }
        return movesToWin;
    }

//        builder.append(1).append(System.lineSeparator());
//        builder.append(1).append(System.lineSeparator());
//        builder.append(rows).append(System.lineSeparator());
//        builder.append(columns).append(System.lineSeparator());
//        builder.append(patternLength).append(System.lineSeparator());
//        toReturn.add(builder.toString());
}

