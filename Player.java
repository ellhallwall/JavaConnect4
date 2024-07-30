//Used an abstract class to be the foundation of both human and computer players

public abstract class Player {
    // fields
    protected char counter;
    protected Display display;

    // constructors
    public Player(char counter) {
        this.counter = counter;
        this.display = new Display();

    }

    // getter method for the players' pieces to be used in  gameLogic
    public char getCounter() {
        return counter;
    }

    //getter method for the displayMessages
    protected Display getDisplay() {
        return display;
    } 

    // abstract method to define unique behaviours in the human and computer players
    // classes
    public abstract int playerMove(Board board);
}