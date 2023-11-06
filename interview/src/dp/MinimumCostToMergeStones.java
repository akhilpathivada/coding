/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/description/
 * https://www.codingninjas.com/studio/problems/merging-stones_3210617
 *
 * Time Complexity : O(N ^ 3)
 * Space Complexity : O(N ^ 2)
 * */
package dp;

import java.util.Arrays;

public class MinimumCostToMergeStones {

    private int f(int[] stones, int[] prefixSum, int k, int i, int n) {
        // base case : invalid index or
        // for single element answer is always 0
        if (i + k - 1 > n) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; j += k - 1) {
            min = Math.min(min, f(stones, prefixSum, k, i, j) + f(stones, prefixSum, k, j + 1, n));
        }
        if ((n - i) % (k - 1) == 0) {
            min += prefixSum[n + 1] - prefixSum[i];
        }
        return min;
    }

    private int memoize(int[] stones, int[] prefixSum, int[][] dp, int k, int i, int n) {
        // base case : invalid index or
        // for single element answer is always 0
        if (i + k - 1 > n) {
            return 0;
        }
        if (dp[i][n] != -1) {
            return dp[i][n];
        }
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; j += k - 1) {
            min = Math.min(min, memoize(stones, prefixSum, dp, k, i, j) + memoize(stones, prefixSum, dp, k, j + 1, n));
        }
        if ((n - i) % (k - 1) == 0) {
            min += prefixSum[n + 1] - prefixSum[i];
        }
        return dp[i][n] = min;
    }


    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        // store the prefix sum, instead of iterating for sum every time for any window
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = stones[0];
        for (int i = 1; i <= n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        // recursion
        System.out.println(f(stones, prefixSum, k, 0, n - 1));

        // memoization
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        memoize(stones, prefixSum, dp, k, 0, n - 1);

        // tabulation - yet to do

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] stones = { 3, 2, 4, 1 };
        int k = 2;
        System.out.println(new MinimumCostToMergeStones().mergeStones(stones, k));
    }
}
