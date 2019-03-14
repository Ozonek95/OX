package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Board {
    private Field[][] fields;
    private int numberOfFields;
    private int rows;
    private int columns;
    Board(int rows, int columns) {
        initializeBoard(rows, columns);
        this.rows=rows;
        this.columns=columns;
    }

    private void initializeBoard(int rows, int columns) {
        fields = new Field[rows][columns];
        for (int i=0;i<columns;i++){
            for (int j=0;j<rows;j++){
                fields[j][i] = new Field();
                numberOfFields++;
            }
        }
    }

    int getFieldsNumber() {
        return numberOfFields;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    //ZAKŁADAM, ŻE BĘDĘ ZACZYNAŁ INDEKSY OD 1
    Field getField(int rows, int columns) {
        return fields[rows][columns];
    }

    void setField(int row, int column, Figure figure) {
        Field field = new Field();
        field.setState(figure);
        fields[row][column] = field;
    }
}
