package tick_tac_toe;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;

    public Game(Player p1, Player p2) {
        board = new Board();
        players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        currentPlayerIndex = 0;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        Player currentPlayer;
        boolean gameOn = true;

        while (gameOn) {
            board.display();
            currentPlayer = players.get(currentPlayerIndex);
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter row and column (0–2): ");
            int row = sc.nextInt(), col = sc.nextInt();

            if (board.placeMark(row, col, currentPlayer.getSymbol())) {
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println(currentPlayer.getName() + " wins!");
                    gameOn = false;
                } else if (board.isFull()) {
                    board.display();
                    System.out.println("It's a draw!");
                    gameOn = false;
                } else {
                    currentPlayerIndex = (currentPlayerIndex + 1) % 2;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}
