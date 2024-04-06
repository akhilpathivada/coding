/**
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 *
 * Time Complexity: O(m *n)
 * Space Complexity: O(m *n)
 *
 * */
package dp.path;

import java.util.Arrays;

public class MinimumFallingPathSumI {

    private int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        // fill the first row of dp
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
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
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(new MinimumFallingPathSumI().minFallingPathSum(matrix));
    }
}
