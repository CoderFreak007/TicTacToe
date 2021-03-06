package org.practice.model;

public class Cell {

    private int row;

    private int column;

    private CellType cellType;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellType = CellType.EMPTY;
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
}
