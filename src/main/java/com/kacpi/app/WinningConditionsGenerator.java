package com.kacpi.app;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kacper Staszek
 */
class WinningConditionsGenerator {
    List<String> automaticGameDrawGenerator(int rows, int columns, int patternLength) {
        List<String> toReturn = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
//        builder.append(1).append(System.lineSeparator());
//        builder.append(1).append(System.lineSeparator());
//        builder.append(rows).append(System.lineSeparator());
//        builder.append(columns).append(System.lineSeparator());
//        builder.append(patternLength).append(System.lineSeparator());
//        toReturn.add(builder.toString());
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
}

