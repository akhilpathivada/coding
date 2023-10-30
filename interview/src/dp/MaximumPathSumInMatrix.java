/**
 * https://www.codingninjas.com/studio/problems/maximum-path-sum-in-the-matrix_797998
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * */
package dp;

public class MaximumPathSumInMatrix {

    public int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        // fill the first row
        for (int j = 0; j < n; ++j) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // from upwards
                int up = matrix[i][j] + dp[i - 1][j];
                // from left diagonal
                int ld = matrix[i][j];
                if (j - 1 >= 0) {
                    ld += dp[i - 1][j - 1];
                } else {
                    ld = Integer.MIN_VALUE;
                }
                // from right diagonal
                int rd = matrix[i][j];
                if (j + 1 <= n - 1) {
                    rd += dp[i - 1][j + 1];
                } else {
                    rd = Integer.MIN_VALUE;
                }
                dp[i][j] = Math.max(up, Math.max(ld, rd));
            }
        }
        // check which cell has max. value in the last row
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, dp[m - 1][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };
        System.out.println(new MaximumPathSumInMatrix().getMaxPathSum(matrix));
    }
}
