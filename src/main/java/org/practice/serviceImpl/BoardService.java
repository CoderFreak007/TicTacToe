package org.practice.serviceImpl;

import org.practice.model.Board;
import org.practice.model.Cell;
import org.practice.model.CellType;
import org.practice.model.Player;
import org.practice.service.RuleService;

public class BoardService {

    private RuleService ruleService = new DefaultRuleService();

    public void makeMove(Board board, int row , int column, CellType cellType) throws Exception {

        Cell[][] cellsOnBoard = board.getCellsOnBoard();
        Player currentPlayer = board.getCurrentPlayer();
        if(currentPlayer.isValidPiece(cellType) && board.isValidMove(row, column)){
            Cell cell = cellsOnBoard[row][column];
            cell.setCellType(cellType);
            printBoard(board);
            if(ruleService.isGameWon(board)) {
                board.setGameWon(true);
            }else if(ruleService.isGameOver(board))
                board.setGameOver(true);
            else
                board.switchPlayers();
        }else
            throw new Exception("Invalid Move");

    }

    private void printBoard(Board board){
        for(int i=0; i< Board.BOARD_DEFAULT_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_DEFAULT_SIZE; j++) {
                System.out.print(board.getCellsOnBoard()[i][j].getCellType().getValue());
                System.out.print(" ");
            }
            System.out.println(System.lineSeparator());
        }

    }

}
