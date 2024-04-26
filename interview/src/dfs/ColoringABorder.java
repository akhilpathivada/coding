package dfs;

import java.util.Arrays;

/**
 * Date 26/04/24
 * Time 11:08
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/coloring-a-border/description/
 *
 */
public class ColoringABorder {

    private int dfs(final int[][] grid, final boolean[][] visited, final int actualColor, final int newColor,
                    final int i, final int j, final int m, final int n) {
        if (i < 0 || i == m || j < 0 || j == n
                || (!visited[i][j] && grid[i][j] != actualColor)) { // if neighbor not belongs to the component
            return 0;
        }
        if (grid[i][j] == newColor) {
            return 1;
        }
        visited[i][j] = true;
        if (dfs(grid, visited, actualColor, newColor, i - 1, j, m, n)
                + dfs(grid, visited, actualColor, newColor, i + 1, j, m, n)
                + dfs(grid, visited, actualColor, newColor, i, j - 1, m, n)
                + dfs(grid, visited, actualColor, newColor, i, j + 1, m, n) < 4) {
            // color the cell
            grid[i][j] = newColor;
        }
        return 1;
    }

    private int[][] colorBorder(int[][] grid, int row, int col, int color) {
        final int m = grid.length;
        final int n = grid[0].length;
        dfs(grid, new boolean[m][n], grid[row][col], color, row, col, m, n);
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int row = 1, col = 1, color = 2;
        System.out.println(Arrays.deepToString(new ColoringABorder().colorBorder(grid, row, col, color)));
    }
}
