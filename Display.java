public class Display {
    
    //Game Introduction
    public void gameIntro() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
    }

    //method to print out the board
    public void displayBoard(Board board) {
        char[][] currentBoard = board.getBoard();
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[i].length; j++) {
                if (currentBoard[i][j] == 'r') {
                    System.out.print("| r ");
                } else if (currentBoard[i][j] == 'y') {
                    System.out.print("| y ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    //win message
    public void winMessage(char player) {
        if (player == 'r') {
            System.out.println("Player 1 Wins!");
        } else if (player == 'y') {
            System.out.println("Player 2 Wins!");
        }
    }

    //Draw message
    public void drawMessage() {
        System.out.println("The game is a draw");
    }

    //Pick Column metho
    public void pickColumnMessage() {
        System.out.println("Pick a column between 1 and 7");
    }

    // Column is full
    public void columnIsFullMessage() {
        System.out.println("Column is full. Please select another column.");
    }

    // Invalid input
    public void invalidInputMessage() {
        System.out.println("Invalid input. Please select a column between 1 and 7.");
    }

    // Turn management messages
    public void signalPlayerMoveMessage(char player) {
        if (player == 'r') {
            System.out.println("Player 1's move");
        } else if (player == 'y') {
            System.out.println("Player 2's move");
        }
    }
}