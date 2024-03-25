/**
 * @author akhilpathivada
 * <p>
 * date : 25/03/24
 * time: 08:46
 *
 * https://leetcode.com/problems/game-of-life/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(1)
 */
package matrix;

import java.util.Arrays;

public class GameOfLife {

    private void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int count = 0;
                for (int[] direction : directions) {
                    int p = i + direction[0];
                    int q = j + direction[1];
                    if (p >= 0 && p < m && q >= 0 && q < n && (board[p][q] == 1 || board[p][q] == 2)) {
                        ++count;
                    }
                }
                // if count 2: turn alive to dead
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                } else { // if count 3: turn dead to alive
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] %= 2;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        new GameOfLife().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
