/**
 * https://leetcode.com/problems/unique-paths-iii/
 *
 * Time Complexity : O(N ^ 4)
 * Space Complexity : O(N ^ 2)
 */
package dfs;

public class UniquePathsIII {

    private int zeros = 0;

    private int dfs(int[][] grid, int i, int j, int m, int n, int zeros) {
        // anchor condition
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return zeros == -1 ? 1 : 0;
        }
        // mark as visited
        grid[i][j] = -1;
        // reduce count of zeros
        --zeros;
        int paths =  dfs(grid, i + 1, j, m, n, zeros) +
        dfs(grid, i - 1, j, m, n, zeros) +
        dfs(grid, i, j + 1, m, n, zeros) +
        dfs(grid, i, j - 1, m, n, zeros);
        // revert back count of zeros
        ++zeros;
        // mark as unvisited
        grid[i][j] = 0;
        return paths;
    }

    private int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // co-ordinates of starting point
        int x = -1, y = -1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // count zeros
                if (grid[i][j] == 0) {
                    ++zeros;
                } else if (grid[i][j] == 1) { // found the starting point
                    x = i;
                    y = j;
                }
            }
        }
        return dfs(grid, x, y, m, n, zeros);
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
        System.out.println(new UniquePathsIII().uniquePathsIII(grid));
    }
}
