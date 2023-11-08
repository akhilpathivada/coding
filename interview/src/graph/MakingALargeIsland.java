package graph;

public class MakingALargeIsland {

    private int dfs(int[][] grid, boolean[][] visited,int i, int j, int m, int n) {
        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] != 1 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int area = 1 + dfs(grid,visited, i + 1, j, m, n)
                + dfs(grid,visited, i - 1, j, m, n)
                + dfs(grid,visited, i, j + 1, m, n)
                + dfs(grid,visited, i, j - 1, m, n);
        return area;
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int previousState = grid[i][j];
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j, m, n));
                    visited[i][j] = true;
                }
                grid[i][j] = previousState;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid =  {{1,1},{1,0}};
        System.out.println(new MakingALargeIsland().largestIsland(grid));
    }
}
