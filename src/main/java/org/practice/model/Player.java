package org.practice.model;

public class Player {

    private String name;

    private CellType pieceAssigned;

    public Player(String name, char pieceValue) {
        this.name = name;
        this.pieceAssigned = CellType.getCellType(pieceValue);
    }

    public String getName() {
        return name;
    }

    public CellType getPieceAssigned() {
        return pieceAssigned;
    }

    public boolean isValidPiece(CellType piece){
        return pieceAssigned.equals(piece);
    }
}
