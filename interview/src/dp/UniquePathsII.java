/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 */
package dp;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 1 && j == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
    }
}
