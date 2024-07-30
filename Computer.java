import java.util.Random;

public class Computer extends Player {
    
    // Variable for the computer to generate a random move
    private Random randomMove = new Random();

    //Initilise the counter from parent
    public Computer(char counter) {
        super(counter);
    }

    // Override Method to generate a random move within the rules of the game
    // Checks whether the move isValid before progressing
    public int playerMove(Board board) {
        System.out.println();
        display.signalPlayerMoveMessage('y');

        int chosenColumn;
        do {
            chosenColumn = randomMove.nextInt(7);
        } while (!board.isMoveValid(chosenColumn));
        return chosenColumn;
    }
}