/**
 * Date 10/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/number-of-closed-islands/description/
 *
 *
 */
package dfs;

import java.util.Map;

public class NumberOfClosedIslands {

    private boolean isClosedIsland(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        // base case
        if (i < 0 || i == m || j < 0 || j == n) {
            return false;
        }
        if (grid[i][j] == 1 || visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        boolean isClosed = true;
        isClosed &= isClosedIsland(grid, visited, i - 1, j, m, n);
        isClosed &= isClosedIsland(grid, visited, i + 1, j, m, n);
        isClosed &= isClosedIsland(grid, visited, i, j - 1, m, n);
        isClosed &= isClosedIsland(grid, visited, i, j + 1, m, n);
        return isClosed;
    }

    private int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int countOfClosedIslands = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (grid[i][j] == 0 && !visited[i][j] && isClosedIsland(grid, visited, i, j, m, n)) {
                    ++countOfClosedIslands;
                }
            }
        }
        return countOfClosedIslands;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(new NumberOfClosedIslands().closedIsland(grid));
    }
}
