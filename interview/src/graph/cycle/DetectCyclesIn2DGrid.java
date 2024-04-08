package graph.cycle;

/**
 * Date 08/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/description/
 *
 *
 */
public class DetectCyclesIn2DGrid {

    private boolean hasCycle(char[][] grid, boolean[][] visited, int m, int n,
                             int row, int col, int prow, int pcol, char startChar) {
        visited[row][col] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int nrow = row + direction[0];
            int ncol = col + direction[1];
            if (nrow < 0 || nrow == m || ncol < 0 || ncol == n || grid[nrow][ncol] != startChar) {
                continue;
            }
            if (nrow == prow && ncol == pcol) {
                continue;
            }
            // if already visited
            if (visited[nrow][ncol]) {
                return true;
            }
            if (hasCycle(grid, visited, m, n, nrow, ncol, row, col, startChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j]) {
                    if (hasCycle(grid, visited, m, n, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}};
//        char[][] grid = {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        System.out.println(new DetectCyclesIn2DGrid().containsCycle(grid));
    }
}
