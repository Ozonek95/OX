package com.kacpi.app;

/**
 * @author Kacper Staszek
 */
class Board {
    private Field[][] fields;
    private int numberOfFields;
    private int rows;
    private int columns;
    private int patternToWinLength;
    Board(int rows, int columns) {
        initializeBoard(rows, columns);
        this.rows=rows;
        this.columns=columns;
    }

    Board(Settings settings) {
        initializeBoard(settings.getRows(),settings.getColumns());
        this.rows=settings.getRows();
        this.columns=settings.getColumns();
        this.patternToWinLength = settings.getPatternToWinLength();
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

    int getRows() {
        return rows;
    }

    int getColumns() {
        return columns;
    }

    int getPatternToWinLength(){
        return patternToWinLength;
    }

    Field getField(int rows, int columns) {
        return fields[rows][columns];
    }

    void setField(int row, int column, Figure figure) {
        Field field = new Field();
        field.setState(figure);
        fields[row][column] = field;
    }

    void clear() {
        numberOfFields-=numberOfFields;
        initializeBoard(rows,columns);
    }
}
