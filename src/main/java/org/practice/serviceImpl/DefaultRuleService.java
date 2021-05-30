package org.practice.serviceImpl;

import org.practice.model.Board;
import org.practice.model.CellType;
import org.practice.service.RuleService;

public class DefaultRuleService implements RuleService {

    public boolean isGameWon(Board board) {
      return (checkRowMatch(board) || checkColumnMatch(board) || checkDiagonalMatch(board));

    }

    private boolean checkRowMatch(Board board){
        for (int i = 0; i < Board.BOARD_DEFAULT_SIZE; i++) {
            boolean rowMatch = true;
            for(int j= 1; j< Board.BOARD_DEFAULT_SIZE; j++){
                if(board.getCellsOnBoard()[i][j] != board.getCellsOnBoard()[i][j-1]) {
                    rowMatch = false; break;
                }
            }
            if(rowMatch) return true;
        }
        return  false;

    }

    private boolean checkColumnMatch(Board board){
        for (int i = 1; i < Board.BOARD_DEFAULT_SIZE; i++) {
            boolean columnMatch = true;
            for(int j= 0; j< Board.BOARD_DEFAULT_SIZE; j++){
                if(board.getCellsOnBoard()[j][i] != board.getCellsOnBoard()[j][i-1]) {
                    columnMatch = false; break;
                }
            }
            if(columnMatch) return true;
        }
        return  false;

    }

    private boolean checkDiagonalMatch(Board board){
        boolean diagonalMatch = true;
        for (int i = 1; i < Board.BOARD_DEFAULT_SIZE; i++) {
            if(board.getCellsOnBoard()[i][i] != board.getCellsOnBoard()[i-1][i-1]) {
                diagonalMatch = false; break;
            }
        }
        return  diagonalMatch;

    }

    public boolean isGameOver(Board board) {

        for (int i = 0; i < Board.BOARD_DEFAULT_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_DEFAULT_SIZE; j++) {
              if(board.getCellsOnBoard()[i][j].getCellType().equals(CellType.EMPTY))
                  return false;
            }

        }
        return  true;
    }

}
