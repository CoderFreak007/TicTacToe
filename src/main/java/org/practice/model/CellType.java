package org.practice.model;

public enum CellType {
    X('X'), O('O'), EMPTY('-');

    private char value;

    private CellType(char value){
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static CellType getCellType(char piece){

        for(CellType cellType : CellType.values()){
            if(cellType.getValue() == piece)
                return cellType;
        }
        throw new IllegalArgumentException(piece +"is not a valid piece");
    }


}
