package org.practice.model;


import java.util.ArrayDeque;
import java.util.Queue;

public class Board {

    public static int BOARD_DEFAULT_SIZE = 3;

    private Cell[][] cellsOnBoard;

    private Queue<Player> playerQueue;

    private boolean isGameWon = false;

    private boolean isGameOver = false;


    public Board() {
        this.cellsOnBoard = new Cell[BOARD_DEFAULT_SIZE][BOARD_DEFAULT_SIZE];
        populateDefaultBoard();
        playerQueue = new ArrayDeque<>();

    }

    private void populateDefaultBoard(){
        for(int i=0; i< BOARD_DEFAULT_SIZE; i++)
            for(int j=0; j< BOARD_DEFAULT_SIZE; j++)
                this.cellsOnBoard[i][j] = new Cell(i, j);
    }

    public boolean isValidMove(int row, int column){

        if(row >=0 && row < BOARD_DEFAULT_SIZE && column >=0 && column < BOARD_DEFAULT_SIZE){
            Cell cell = this.cellsOnBoard[row][column];
            if(cell.getCellType().equals(CellType.EMPTY))
                return true;
        }
        return false;

    }

    public void addPlayer(Player player){
        playerQueue.add(player);
    }



    public void switchPlayers(){
        playerQueue.add(playerQueue.poll());
    }

    public Player getCurrentPlayer(){
        return playerQueue.peek();
    }

    public Cell[][] getCellsOnBoard() {
        return cellsOnBoard;
    }

    public boolean isGameWon() {
        return isGameWon;
    }

    public void setGameWon(boolean gameWon) {
        isGameWon = gameWon;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
