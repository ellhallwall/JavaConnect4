import java.util.Scanner;
import java.util.InputMismatchException;


public class Human extends Player {
    //Take the input from the user
    private Scanner inputScanner = new Scanner(System.in);

    //Initilise the counter from parent
    public Human(char counter) {
        super(counter);
    }

    // Override Method to take the users input, check whether the move is valid, and return the chosen column to the place counter method    
    public int playerMove(Board board) {
        int chosenColumn;

        while (true) {
            try {
                System.out.println();
                display.signalPlayerMoveMessage('r');
                display.pickColumnMessage();
               
                chosenColumn = inputScanner.nextInt() - 1;

                if (chosenColumn >= 0 && chosenColumn <= 6) {
                    if (board.isMoveValid(chosenColumn)) {
                        break; // Exit if the move is valid
                    } else {
                        display.columnIsFullMessage();
                        continue;
                    }
                } else {
                    display.invalidInputMessage();
                }
            } catch (InputMismatchException IncorrectInput) {
                display.invalidInputMessage();
                inputScanner.next(); // Consume the invalid input
            }
        }

        return chosenColumn;
    }
}