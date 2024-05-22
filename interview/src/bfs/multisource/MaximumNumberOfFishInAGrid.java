/**
 * author: akhilpathivada
 * time: 22/05/24 12:03
 *
 * https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/
 *
 */
package bfs.multisource;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNumberOfFishInAGrid {

    private final class Pair {

        private final int row;

        private final int col;

        private Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int bfs(int[][] grid, Pair cell, boolean[][] visited) {
        // the four directions we can traverse
        final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        final Queue<Pair> queue = new LinkedList<>();
        queue.add(cell);
        int fishesCaught = 0;
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.remove();
            if (visited[row][col]) {
                continue;
            }
            fishesCaught += grid[row][col];
            visited[row][col] = true;
            for (int[] direction : directions) {
                int nrow = row + direction[0];
                int ncol = col + direction[1];
                if (nrow < 0 || nrow == grid.length || ncol < 0 || ncol == grid[0].length || grid[nrow][ncol] == 0 || visited[nrow][ncol]) {
                    continue;
                }
                queue.add(new Pair(nrow, ncol));
            }
        }
        return fishesCaught;
    }

    private int findMaxFish(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    result = Math.max(result, bfs(grid, new Pair(i, j), visited));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] grid = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
        int[][] grid = {{10, 5}, {8, 0}};
//        int[][] grid = {{8,6},{2,6}};
        System.out.println(new MaximumNumberOfFishInAGrid().findMaxFish(grid));
    }
}
