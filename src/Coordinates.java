/**
 * Coordinates of the player's move
 */

public class Coordinates {
    private int x;
    private int y;

    public Coordinates() {
        x=-1;
        y=-1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
