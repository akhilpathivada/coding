package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    // Checks whether there is any duplicate
    // in current row or not
    private boolean notInRow(char[][] board, int row) {
        // Set to store characters seen so far.
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; ++i) {
            char currentCharacter = board[row][i];
            // If already encountered before, return false
            if (set.contains(currentCharacter)) {
                return false;
            }
            // If it is not an empty cell,
            // insert value at current cell in set
            if (currentCharacter != '.') {
                set.add(currentCharacter);
            }
        }
        return true;
    }


    // Checks whether there is any duplicate
    // in current column or not
    private boolean notInColumn(char[][] board, int column) {
        // Set to store characters seen so far.
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; ++i) {
            char currentCharacter = board[i][column];
            // If already encountered before, return false
            if (set.contains(currentCharacter)) {
                return false;
            }
            // If it is not an empty cell,
            // insert value at current cell in set
            if (currentCharacter != '.') {
                set.add(currentCharacter);
            }
        }
        return true;
    }

    // Checks whether there is any duplicate
    // in current 3x3 box or not.
    private boolean notInBox(char[][] board, int startRow, int startColumn) {
        Set<Character> set = new HashSet<>();

        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 3; ++column) {
                char currentCharacter = board[row + startRow][column + startColumn];
                // If already encountered before, return false
                if (set.contains(currentCharacter)) {
                    return false;
                }
                // If it is not an empty cell,
                // insert value at current cell in set
                if (currentCharacter != '.') {
                    set.add(currentCharacter);
                }
            }
        }
        return true;
    }

    // Checks whether current row and current column and
    // current 3x3 box is valid or not
    private boolean isValidSudoku(char[][] board, int row, int column) {
        return notInBox(board, row - row % 3, column - column % 3) && notInRow(board, row) && notInColumn(board,
                column);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                // If current row or current column or
                // current 3x3 box is not valid, return false
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; ++c) { //try all number from 1 to 9
                        board[i][j] = c;
                        if (isValidSudoku(board, i, j)) {
//                            board[i][j] = c; //put c for this cell
                            board[i][j] = c;
                            if (backtrack(board))
                                return true; // If it's the solution return true
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        backtrack(board);
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        new SudokuSolver().solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
