/**
 * https://www.codingninjas.com/studio/problems/number-of-subsets_3952532
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(n * k)
 * */
package dp;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    private int f(int[] arr, int k, int n) {
        // base case
        if (k == 0) {
            return 1;
        }
        if (n == 0) {
            return arr[n] == k ? 1 : 0;
        }
        int taken = 0;
        if (arr[n] <= k) {
            taken = f(arr, k - arr[n], n - 1);
        }
        int notTaken = f(arr, k, n - 1);
        return taken + notTaken;
    }

    private int memorize(int[] arr, int k, int n, int[][] dp) {
        // base case
        if (k == 0) {
            return 1;
        }
        if (n == 0) {
            return arr[n] == k ? 1 : 0;
        }
        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        int taken = 0;
        if (arr[n] <= k) {
            taken = memorize(arr, k - arr[n], n - 1, dp);
        }
        int notTaken = memorize(arr, k, n - 1, dp);
        return dp[n][k] = taken + notTaken;
    }

    private int findWays(int[] arr, int k) {
        int n = arr.length;
        // recursion
        System.out.println(f(arr, k, n - 1));
        // memorization
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        memorize(arr, k, n - 1, dp);
        System.out.println(dp[n - 1][k]);
        // tabulation
        dp = new int[n][k + 1];
        // if k == 0
        for (int i = 0; i < n; ++i) {
            dp[i][0] = 1;
        }
        // if arr[0] == k
        for (int i = 0; i <= k; ++i) {
            dp[0][i] = (arr[0] == k) ? 1 : 0;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                int taken = 0;
                if (arr[i] <= j) {
                    taken = dp[i - 1][j - arr[i]];
                }
                int notTaken = dp[i - 1][j];
                dp[i][j] = taken + notTaken;
            }
        }
        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 4, 5 };
        int k = 5;
        System.out.println(new CountSubsetsWithSumK().findWays(arr, k));
    }
}
