/**
 * Player
 */
public class Player {
    private String name;
    private char symbol;
    private boolean winner;

    public Player() {
        this.winner = false;
    }

    public void setWinner() {
        this.winner = true;
    }

    /**
     * set the winner's flag to false
     */
    public void unsetWinner() {
        this.winner = false;
    }

    /**
     * detects if the player is winner
     *
     * @return true if the player is winner
     */
    public boolean isWinner() {
        return winner;
    }

    public void addPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }
}
