/**
 * Represents the state of a board in a game of Tic-Tac-Toe
 */
public class Board {
    /**
     * The number of rows and columns in this square Tic-Tac-Toe board
     */
    private static final int SIZE = 3;
    /**
     * A 2D array representing the state of this Tic-Tac-Toe board
     */
    private char[][] currentBoard = new char[SIZE][SIZE];

    /**
     * Creates an empty Tic-Tac-Toe board
     */
    public Board() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                currentBoard[i][j] = ' ';
            }
        }
    }

    /**
     * prints the current board
     */
    public void print() {
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                System.out.print(currentBoard[j][i]);
                if (i < SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (j < SIZE - 1) {
                for (int i = 0; i < (SIZE * 2) - 1; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    /**
     * Converts an integer board location into a column number in currentBoard.
     *
     * @param position an integer board position in range [1-9]
     * @return an integer column number in range [0-2]
     * @see Board#currentBoard
     */
    public int getColumn(int position) {
        return (position - 1) % SIZE;
    }

    /**
     * Converts an integer board location into a row number in currentBoard.
     *
     * @param position an integer board position in range [1-9]
     * @return an integer row number in range [0-2]
     * @see Board#currentBoard
     */
    public int getRow(int position) {
        return (position - 1) / SIZE;
    }

    /**
     * Add move to the board
     *
     * @throws Exception if location is invalid or already full
     */
    public void play(char currentPlayer, int location) throws Exception {
        if (location < 0 || location > SIZE * SIZE) {
            throw new Exception("CANNOT PLAY THERE");
        }
        int row = getRow(location);
        int column = getColumn(location);
        if (isFilled(row, column)) {
            throw new Exception("CANNOT PLAY THERE");
        }
        currentBoard[row][column] = currentPlayer;
    }

    /**
     * @return true if the currentBoard already has an 'X' or an 'O' at
     * [row][column].
     */
    public boolean isFilled(int row, int col) {
        if (currentBoard[row][col] == 'X' || currentBoard[row][col] == 'O') {
            return true;
        }
        return false;
    }

    /**
     * @return true if all the spaces on the board are
     */
    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!isFilled(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return true if currentPlayer has won the game
     */
    public boolean hasWon(char currentPlayer) {

        // checks for horizontal victory
        int hWinners = 0;
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (currentBoard[j][i] == currentPlayer) {
                    hWinners++;
                }
            }
            if (hWinners == SIZE) {
                return true;
            }
            hWinners = 0;
        }

        // checks for vertical victory
        int vWinners = 0;
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (currentBoard[i][j] == currentPlayer) {
                    vWinners++;
                }
            }
            if (vWinners == SIZE) {
                return true;
            }
            vWinners = 0;
        }

        // checks for right to left diagonal victory
        int dWinner = 0;
        for (int i = 0; i < SIZE; i++) {
            if (currentBoard[i][i] == currentPlayer) {
                dWinner ++;
            }
        }
        if (dWinner == SIZE) {
            return true;
        }

        // checks for left to right diagonal victory
        dWinner = 0;
        for (int i = 0; i < SIZE; i++) {
            if (currentBoard[(SIZE -1)-i][i] == currentPlayer) {
                dWinner ++;
            }
        }
        if (dWinner == SIZE) {
            return true;
        }

        return false;
    }
}
