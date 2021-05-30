package org.practice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.practice.model.Board;
import org.practice.serviceImpl.GameService;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void shouldAnswerWithTrue() throws Exception {

        GameService gameService = new GameService();
        Board board = gameService.buildNewGame('X', "Krishna",
                'O', "Gupta");
        gameService.makeMove(board, 0, 2, 'X');
        assertFalse( board.isGameOver() );

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeption() throws Exception {

        GameService gameService = new GameService();
        Board board = gameService.buildNewGame('X', "Krishna",
                'O', "Gupta");
        gameService.makeMove(board, 0, 2, 'X');
        gameService.makeMove(board, 0, 2, 'Y');
        assertFalse( board.isGameOver() );

    }
}
