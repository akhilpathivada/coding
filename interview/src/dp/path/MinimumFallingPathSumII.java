/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/description/
 *
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n ^ 2)
 *
 * */
package dp.path;

import java.util.Arrays;

public class MinimumFallingPathSumII {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int[] left = new int[n];
        int[] right = new int[n];
        // compute min of an element on its left side
        left[0] = Integer.MAX_VALUE;
        int minSoFar = matrix[0][0];
        for (int i = 1; i < n; ++i) {
            left[i] = minSoFar;
            minSoFar = Math.min(minSoFar, matrix[0][i]);
        }
        // compute min of an element on its right side
        minSoFar = matrix[0][n - 1];
        right[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; --i) {
            right[i] = minSoFar;
            minSoFar = Math.min(minSoFar, matrix[0][i]);
        }
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = matrix[i][j] + Math.min(left[j], right[j]);
            }
            // compute min of an element on its left side
            left[0] = Integer.MAX_VALUE;
            minSoFar = dp[i][0];
            for (int j = 1; j < n; ++j) {
                left[j] = minSoFar;
                minSoFar = Math.min(minSoFar, dp[i][j]);
            }
            // compute min of an element on its right side
            minSoFar = dp[i][n - 1];
            right[n - 1] = Integer.MAX_VALUE;
            for (int j = n - 2; j >= 0; --j) {
                right[j] = minSoFar;
                minSoFar = Math.min(minSoFar, dp[i][j]);
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(new MinimumFallingPathSumII().minFallingPathSum(matrix));
    }
}
