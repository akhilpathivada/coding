/**
 * https://leetcode.com/problems/n-queens/description/
 * */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    private List<String> construct(char[][] board) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            --row;
            --col;
        }
        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            --col;
        }
        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') {
                return false;
            }
            --col;
            ++row;
        }
        return true;
    }

    private void backtrack(char[][] board, List<List<String>> result, int col) {
        if (col == board[0].length) {
            result.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; ++row) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, result, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(board, result, 0);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new NQueens().solveNQueens(n));
    }
}
