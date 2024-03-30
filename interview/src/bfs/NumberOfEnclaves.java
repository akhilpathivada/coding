/**
 * @author akhilpathivada
 * <p>
 * date : 30/03/24
 * time: 07:05
 *
 * https://leetcode.com/problems/number-of-enclaves/description/
 *
 * Time Complexity: O(m * n * 4)
 * Space Complexity: O(m * n)
 *
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    private static class Pair {

        private final int first;

        private final int second;

        private Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();
        // take only the 1s on boundaries and add it to the queue
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));
                }
            }
        }
        // the four directions we can check
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // perform bfs from the boundaries
        while (!queue.isEmpty()) {
            Pair cell = queue.poll();
            int row = cell.first;
            int col = cell.second;
            for (int[] direction : directions) {
                int nrow = row + direction[0];
                int ncol = col + direction[1];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1 && !visited[nrow][ncol]) {
                    // mark the neighbor cell as reachable from a boundary cell
                    visited[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
        // count the cells which are unreachable from any of the boundary cell
        int countOfEnclaves = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ++countOfEnclaves;
                }
            }
        }
        return countOfEnclaves;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        System.out.println(new NumberOfEnclaves().numEnclaves(grid));
    }
}
