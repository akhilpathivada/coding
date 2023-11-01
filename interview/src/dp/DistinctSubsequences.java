/**
 * https://leetcode.com/problems/distinct-subsequences/description/
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * */
package dp;

import java.util.Arrays;

public class DistinctSubsequences {

    private int f(String s, String t, int i, int j) {
        // base cases
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (s.charAt(i) == t.charAt(j)) {
            return f(s, t, i - 1, j - 1) + f(s, t, i - 1, j);
        }
        return f(s, t, i - 1, j);
    }

    private int memorize(String s, String t, int i, int j, int[][] dp) {
        // base cases
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = memorize(s, t, i - 1, j - 1, dp) + memorize(s, t, i - 1, j, dp);
        }
        return dp[i][j] = memorize(s, t, i - 1, j, dp);
    }

    private int numDistinct(String s, String t) {
        // recursion
        int m = s.length();
        int n = t.length();
        System.out.println(f(s, t, m - 1, n - 1));
        // memorization
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        memorize(s, t, m - 1, n - 1, dp);
        System.out.println(dp[m - 1][n - 1]);
        // tabulation
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(new DistinctSubsequences().numDistinct(s, t));
    }
}
