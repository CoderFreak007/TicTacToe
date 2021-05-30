package org.practice;

import org.practice.model.Board;
import org.practice.serviceImpl.GameService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Scanner scanner = new Scanner(System.in);

        GameService gameService = new GameService();
        Board board = gameService.buildNewGame(scanner.next().toCharArray()[0], scanner.next(),
                scanner.next().toCharArray()[0], scanner.next());

        System.out.println("Enter Move");
        String line = scanner.next();
        while (!"exit".equals(line)){

        try {
            gameService.makeMove(board, Integer.parseInt(line), scanner.nextInt(),
                    scanner.next().toCharArray()[0]);
            if (board.isGameWon()) {
                System.out.println(board.getCurrentPlayer().getName() + " Won the Game");
                break;
            }
            if (board.isGameOver()) {
                System.out.println("Game Over");
                break;
            }
            System.out.println("Enter Move");
            line = scanner.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
}
