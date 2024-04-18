/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(1)
 * */
package matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    // Checks whether there is any duplicate
    // in current row or not
    private static boolean notInRow(char[][] board, int row) {
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
    private static boolean notInColumn(char[][] board, int column) {
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
    private static boolean notInBox(char[][] board, int startRow, int startColumn) {
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
    private static boolean isValidSudoku(char[][] board, int row, int column) {
        return notInBox(board, row - row % 3, column - column % 3) && notInRow(board, row) && notInColumn(board,
                column);
    }

    private static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                // If current row or current column or
                // current 3x3 box is not valid, return false
                if (!isValidSudoku(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
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
        System.out.println(isValidSudoku(board));
    }
}
