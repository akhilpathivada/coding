/**
 * Date 25/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 * https://www.codingninjas.com/studio/problems/minimum-path-sum_985349
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 *
 */
package dp.path;

public class MinimumPathSum {

    private int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 },
                         { 1, 5, 1 },
                         { 4, 2, 1 }
        };
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }
}
