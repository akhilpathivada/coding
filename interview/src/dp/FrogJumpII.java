/**
 * https://atcoder.jp/contests/dp/tasks/dp_b
 *
 * Time Complexity : O(N * K)
 * Space Complexity : O(N)
 *
 * */
package dp;

import java.util.Arrays;

public class FrogJumpII {

    private int solveUtil(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;

        for (int i = 1; i < n; ++i) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; ++j) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }

    // Function to find the minimum cost to reach the end of the array
    private int solve(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize a memoization array to store calculated results
        return solveUtil(n, height, dp, k); // Start the recursion from the last index
    }

    public static void main(String args[]) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 2;
        System.out.println(new FrogJumpII().solve(n, height, k)); // Print the result of the solve function
    }
}
