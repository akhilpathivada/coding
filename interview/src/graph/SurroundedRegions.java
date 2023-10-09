/**
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N)
 * */

package graph;

import java.util.Arrays;

public class SurroundedRegions {

    private void DFS(char[][] board, int i, int j, int m, int n) {
        // base case
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X') {
            return;
        }

        if (board[i][j] == 'O') {
            // mark the 'O' with '$'
            board[i][j] = '$';
            DFS(board, i + 1, j, m, n);
            DFS(board, i - 1, j, m, n);
            DFS(board, i, j + 1, m, n);
            DFS(board, i, j - 1, m, n);
        }
    }

    private void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // if we are on boundaries of grid and cell is 'O'
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    DFS(board, i, j, m, n);
                }
            }
        }
        // replace all '$' with 'O' and 'O' with 'X'
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };
        new SurroundedRegions().solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
