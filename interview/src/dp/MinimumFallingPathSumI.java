/**
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 *
 * Time Complexity: O(m *n)
 * Space Complexity: O(m *n)
 *
 * */
package dp;

public class MinimumFallingPathSumI {

    private int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; ++i) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // from up
                int up = dp[i - 1][j];
                // from left diagonal
                int ld = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    ld = dp[i - 1][j - 1];
                }
                // from right diagonal
                int rd = Integer.MAX_VALUE;
                if (j + 1 < n) {
                    rd = dp[i - 1][j + 1];
                }
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(ld, rd));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(new MinimumFallingPathSumI().minFallingPathSum(matrix));
    }
}
