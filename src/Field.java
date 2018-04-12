/**
 * Game field
 */
public class Field {
    private char[][] gameField;

    public Field() {
        gameField = new char[4][4];
    }

    /**
     * Initialize the field
     */
    public void init() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = '-';
            }
        }
    }

    /**
     * Add symbol to the game field
     *
     * @param xy     coordinates of the player move
     * @param symbol player's symbol
     */
    public void addShot(Coordinates xy, char symbol) {
        gameField[xy.getX()][xy.getY()] = symbol;
    }

    /**
     * display the game field
     */
    public void showGameField() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print("[" + gameField[i][j] + "]");
            }
            System.out.println();
        }
    }

    /**
     * detects if there is a winning combination
     *
     * @return true if there is a winning combination
     */
    public boolean isWin() {
        //horizontal check
        boolean win = true;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length - 1; j++) {
                if (gameField[i][j] != gameField[i][j + 1]) {
                    win = false;
                    break;
                }
            }
            if (win && gameField[i][0] != '-') return true;
            win = true;
        }
        //vertical check
        win = true;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length - 1; j++) {
                if (gameField[j][i] != gameField[j + 1][i]) {
                    win = false;
                    break;
                }
            }
            if (win && gameField[0][i] != '-') return true;
            win = true;
        }
        //diagonal check (from left to right)
        win = true;
        for (int i = 0; i < gameField.length - 1; i++) {

            if (gameField[i][i] != gameField[i + 1][i + 1]) {
                win = false;
                break;
            }
        }
        if (win && gameField[0][0] != '-') return true;
        //diagonal check (from right to left)
        win = true;
        for (int i = 0; i < gameField.length - 1; i++) {

            if (gameField[i][(gameField.length - 1) - i] != gameField[i + 1][(gameField.length - 1) - i - 1]) {
                win = false;
                break;
            }
        }
        if (win && gameField[0][gameField.length - 1] != '-') return true;
        return false;
    }

    /**
     * @param coordinates coordinates of the player move
     * @return true if the cell is already used
     */
    public boolean isCellAlreadyUsed(Coordinates coordinates) {
        if (gameField[coordinates.getX()][coordinates.getY()] != '-') return true;
        return false;
    }

}
