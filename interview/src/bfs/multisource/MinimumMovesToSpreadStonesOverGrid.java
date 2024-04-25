package bfs.multisource;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 25/04/24
 * Time 09:41
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/
 *
 */
public class MinimumMovesToSpreadStonesOverGrid {

    private int minimumMoves(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        // the four directions we can traverse
        final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int moves = 0;
        while (!queue.isEmpty()) {
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            queue.remove();
            for (int[] direction : directions) {
                int nrow = row + direction[0];
                int ncol = col + direction[1];
                if (nrow < 0 || nrow == m || ncol < 0 || ncol == n
                        || grid[row][col] == 1 || grid[nrow][ncol] == 1) {
                    continue;
                }
                ++grid[nrow][ncol];
                --grid[row][col];
                ++moves;
                if (grid[row][col] > 1) {
                    grid[nrow][ncol] = grid[row][col];
                    grid[row][col] = 1;
                    queue.add(new int[] {nrow, ncol});
                }
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 0}, {1, 0, 0}, {1, 0, 3}};
        System.out.println(new MinimumMovesToSpreadStonesOverGrid().minimumMoves(grid));
    }
}
