package tick_tac_toe;
import java.util.Arrays;

public class Board {
    private char[][] board;
    private int size = 3;

    public Board() {
        board = new char[size][size];
        for (char[] row : board)
            Arrays.fill(row, ' ');
    }

    public boolean placeMark(int row, int col, char symbol) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public void display() {
        for (char[] row : board) {
            for (char cell : row)
                System.out.print("| " + cell + " ");
            System.out.println("|");
        }
    }

    public boolean checkWin(char symbol) {
        // Check rows, cols, diagonals
        for (int i = 0; i < size; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public boolean isFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }
}

