//notes
// at the end of developing I thought of another 

import java.util.Scanner;

public class GameLogic {
    //fields
    private Board board;
    private Display display;
    private Player player1;
    private Player player2;
    Scanner newGame = new Scanner(System.in);
    String answer;

    //constructor to initiliase the board, players, and display
    public GameLogic() {
        board = new Board();
        display = new Display();
        display.gameIntro();
        player1 = new Human('r');
        player2 = new Computer('y');
        playCounter();
    }

    //method for each player to play counter
    //The board is displayed. Then the move is taken from the input, is checked for validity, placed and then the result is reviewed before changing player
    public void playCounter() {
        display.displayBoard(board);
        while (true) {
            // Player 1's turn
            int firstMove = player1.playerMove(board);
            board.placeCounter(firstMove, player1.getCounter());
            display.displayBoard(board);
            if (checkResult(player1.getCounter())) {
                display.winMessage('r');
                break;
            }
            // Player 2's turn
            int secondMove = player2.playerMove(board);
            board.placeCounter(secondMove, player2.getCounter());
            display.displayBoard(board);
            if (checkResult(player2.getCounter())) {
                display.winMessage('y');
                break;
            }

            // Check if the result is a draw
            if (checkDraw()) {
                display.drawMessage();
                break;
            }
        }
    }

    //Method to check the result
    public boolean checkResult(char player) {
        int count = 0;
        char[][] currentBoard = board.getBoard();

        // // Code to check the horizontal winning condition
        // // loops through the row, to count players counters to assess win condition
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[i].length; j++) {
                if (currentBoard[i][j] == player) {
                    count = count + 1;
                    if (count >= 4) {
                        // System.out.println("horizontal win"); for testing
                        return true;
                    }
                } else {
                    count = 0; // Resets the count
                }
            }
        }

        // Code to check the vertical winning condition
        // loops through the column, to count players counters to assess win condition
        for (int i = 0; i < currentBoard[0].length; i++) {
            for (int j = 0; j < currentBoard.length; j++) {
                if (currentBoard[j][i] == player) {
                    count = count + 1;
                    if (count >= 4) {
                        // System.out.println("vertical win"); // for testing
                        return true;
                    }
                } else {
                    count = 0; // Resets the count
                }
            }
        }

        // Code to check the diagonal winning condition from left to right
        // The loop uses - 3 to keep within index of the board when checking
        // The check uses index positions to check the diagnoal patttern
        for (int i = 0; i < currentBoard.length - 3; i++) {
            for (int j = 0; j < currentBoard[i].length - 3; j++) {
                if (currentBoard[i][j] == player &&
                        currentBoard[i + 1][j + 1] == player &&
                        currentBoard[i + 2][j + 2] == player &&
                        currentBoard[i + 3][j + 3] == player) {
                    // System.out.println("L2R diag win"); // for testing
                    return true;
                }
            }
        }

        // // code to check the diagonal winning condition from right to left
        // // the loop uses - 3 to keep within index of the board when checking
        // // the check uses index positions to check the diagnoal patttern
        for (int i = currentBoard.length - 1; i >= 3; i--) {
            for (int j = 0; j < currentBoard[i].length - 3; j++) {
                if (currentBoard[i][j] == player &&
                        currentBoard[i - 1][j + 1] == player &&
                        currentBoard[i - 2][j + 2] == player &&
                        currentBoard[i - 3][j + 3] == player) {
                    // System.out.println("R2L diag win"); //for testing
                    return true;
                }
            }
        }

        return false; // end checkWin method when no condition is met
    }

    // Method to check for the draw
    // loops through the columns, if all top positions are full with no winner. It is draw
    public boolean checkDraw() {
        char[][] currentBoard = board.getBoard();
        for (int j = 0; j < currentBoard[0].length; j++) {
            if (currentBoard[0][j] == ' ') {
                return false; // Game is still active
            }
        }
        return true; // Game is a draw
    }

}
