/**
 *
 * https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/description/
 *
 * Time Complexity: O(N ^ 4)
 * Space Complexity: O(N ^ 2)
 * */
package graph;

public class MinimumNumberOfDaysToDisconnectIsland {

    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        // base case
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        // mark as visited
        visited[i][j] = true;
        // recur on its neighbours
        dfs(grid, visited, i + 1, j, m, n);
        dfs(grid, visited, i - 1, j, m, n);
        dfs(grid, visited, i, j + 1, m, n);
        dfs(grid, visited, i, j - 1, m, n);
    }

    private int numberOfIslands(int[][] grid, int m, int n) {
        int countOfIslands = 0;
        // we can't change the original grid : so take a new visited grid
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ++countOfIslands;
                    dfs(grid, visited, i, j, m, n);
                }
            }
        }
        return countOfIslands;
    }

    private int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // base case : if already disconnected
        if (numberOfIslands(grid, m, n) != 1) {
            return 0;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // island found
                if (grid[i][j] == 1) {
                    // remove it, and see it disconnects the island
                    grid[i][j] = 0;
                    // island is disconnected
                    if (numberOfIslands(grid, m, n) != 1) {
                        return 1;
                    }
                    // revert back to original
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        System.out.println(new MinimumNumberOfDaysToDisconnectIsland().minDays(grid));
    }
}
