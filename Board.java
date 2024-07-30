public class Board {

    // Fields
    private char[][] board = new char[6][7];

    // Contructor
    // Loops through every position on the board and initialises this as a ' ', to
    // enable checks on positions e.g. Full Columns
    public Board() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // methods

    //Method to enable other classes to retrieve board state 
    public char[][] getBoard() {
      return board;
    }

    // Method to place the token on the board
    // Takes the chosen column from the user, and loops through the column from the
    // bottom. If the space is empty, it will place the counter.
    public void placeCounter(int chosenColumn, char counter) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][chosenColumn] == ' ') {
                board[i][chosenColumn] = counter;
                break;
            }
        }
    }
    
    // Method to check if the column is full, and whether a move can be played
    // ths checks if the top column is represented by a " ", the column is not full
    public boolean isMoveValid(int chosenColumn) {
        if (board[0][chosenColumn] == ' ') {
            return true;
        }
        return false;
    }

}