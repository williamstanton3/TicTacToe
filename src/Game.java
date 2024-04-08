// will need an import or two

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Board gameBoard;
    private char currentPlayer;
    // you may want other private members

    /**
     *
     */
    public Game() { // constructor
        gameBoard = new Board();
        currentPlayer = 'X';
    }
    public int getPlayerMove() {
        Scanner userSc = new Scanner(System.in);
        while (true) {
            try { // gets next move if player enters int
                int num = userSc.nextInt();
                return num;
            } catch(InputMismatchException e) { // throws exception if input is not an int
                System.out.println("Enter integer");
                userSc.nextLine();
            }
        }
    }
    public void gameLoop() {
        while (!gameBoard.isFull()) {
            gameBoard.print();
            System.out.print(currentPlayer + "'s turn. Enter a move: ");
            try {
                int location = getPlayerMove();
                gameBoard.play(currentPlayer, location);

                // checks to see if current player won
                if (gameBoard.hasWon(currentPlayer)) {
                    gameBoard.print();
                    System.out.println(currentPlayer + " WINS");
                    break;
                }

                // change player
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                }
                else {
                    currentPlayer = 'X';
                }

            } catch (Exception e) { // throws exception if location is not valid
                System.out.println(e.getMessage());
            }
        }

        // ends game and declares "tie" if board fills up without a winner
        if (gameBoard.isFull()) {
            gameBoard.print();
            System.out.println("Tie!");
        }
    }
}
