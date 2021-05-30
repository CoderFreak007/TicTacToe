package org.practice.serviceImpl;

import org.practice.model.Board;
import org.practice.model.CellType;
import org.practice.model.Player;

public class GameService {

    private BoardService boardService = new BoardService();

    public Board buildNewGame(char player1Piece, String player1Name,
                              char player2Piece, String player2Name){

        Player player1 = new Player(player1Name, player1Piece);
        Player player2 = new Player(player2Name, player2Piece);

        Board board = new Board();
        board.addPlayer(player1);
        board.addPlayer(player2);
        System.out.println("game created for "+player1.getName()+" and "+ player2.getName());
        return board;

    }

    public void makeMove(Board board, int row, int column, char piece) throws Exception {
        CellType pieceType = CellType.getCellType(piece);
        boardService.makeMove(board, row, column, pieceType);
    }
}
