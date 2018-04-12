/**
 * Game logic
 */

import java.util.Scanner;

public class GameXO {
    private Field gameField = new Field();
    private Coordinates coordinates = new Coordinates();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Scanner sc = new Scanner(System.in);

    /**
     * initialize the game
     */
    public void init() {
        getPlayerInfo();

    }

    /**
     * request players' information
     */
    private void getPlayerInfo() {
        String name;
        char symbol;
        System.out.print("Имя первого игрока: ");
        name = sc.next();
        System.out.print("Символ первого игрока (X или O): ");
        symbol = (sc.next()).charAt(0);
        player1.addPlayer(name, symbol);
        System.out.println();
        System.out.print("Имя второго игрока: ");
        name = sc.next();
        System.out.print("Символ второго игрока (X или O): ");
        symbol = (sc.next()).charAt(0);
        player2.addPlayer(name, symbol);

    }

    /**
     * main cycle of the game
     */
    public void newGame() {
        String winner;
        do {
            gameField.init();
            player1.unsetWinner();
            player2.unsetWinner();
            while (true) {
                doShot(player1);
                if (gameField.isWin()) {
                    player1.setWinner();
                    break;
                }
                doShot(player2);
                if (gameField.isWin()) {
                    player2.setWinner();
                    break;
                }
            }
            if (player1.isWinner()) winner = player1.getName();
            else {
                winner = player2.getName();
            }
            System.out.println("   ");
            System.out.println("Победитель " + winner.toUpperCase() + " !!!\n");
            gameField.showGameField();
        } while (isContinue());
    }

    /**
     * requests the coordinates of the move
     * @param player current player
     */
    private void doShot(Player player) {
        System.out.println("   ");
        System.out.println("Ходит " + player.getName().toUpperCase() + "\n");
        gameField.showGameField();
        System.out.print("\n*** " + player1.getName().toUpperCase() + " ходит \"" + player1.getSymbol() + "\" / ");
        System.out.println(player2.getName().toUpperCase() + " ходит \"" + player2.getSymbol() + "\" ***\n");
        do {
            System.out.print("Номер строки: (0,1,2 или 3)");
            coordinates.setX(sc.nextInt());
            System.out.print("Номер столбца: (0,1,2 или 3)");
            coordinates.setY(sc.nextInt());
            if(gameField.isCellAlreadyUsed(coordinates)) System.out.println("Эта клетка уже занята, введите другие координаты");
        } while (gameField.isCellAlreadyUsed(coordinates));
        gameField.addShot(coordinates, player.getSymbol());

    }

    /**
     * requests if it needs to create a new game
     * @return true if it needs to create a new game
     */
    private boolean isContinue() {
        System.out.println("\n\nПродолжить? (Д/Н)");
        if (sc.next().toUpperCase().equals("Д")) {
            System.out.println("\n\nПервым ходить будет " + player1.getName() + " ? (Д/Н)");
            if (sc.next().toUpperCase().equals("Н")) {
                String name;
                name = player1.getName();
                player1.setName(player2.getName());
                player2.setName(name);
            }
            return true;
        }
        return false;

    }

}
