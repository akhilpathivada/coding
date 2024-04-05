/**
 * Date 05/04/2024
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
 *
 * Time Complexity : O(mn)
 * Space Complexity : O(mn)
 */
package dp.lcs;

import java.util.Arrays;

public class MinimumASCIIDeleteSumForTwoStrings {

    private int getASCIIValue(String s) {
        int asciiValue = 0;
        for (char c : s.toCharArray()) {
            asciiValue += c;
        }
        return asciiValue;
    }

    private int f(String s1, String s2, int i, int j) {
        // base case
        if (i < 0) {
            return getASCIIValue(s2.substring(0, j + 1));
        }
        if (j < 0) {
            return getASCIIValue(s1.substring(0, i + 1));
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return f(s1, s2, i - 1, j - 1);
        }
        return Math.min(s1.charAt(i) + f(s1, s2, i - 1, j),
                s2.charAt(j) + f(s1, s2, i, j - 1));
    }

    private int memorize(String s1, String s2, int i, int j, int[][] dp) {
        // base case
        if (i < 0) {
            return getASCIIValue(s2.substring(0, j + 1));
        }
        if (j < 0) {
            return getASCIIValue(s1.substring(0, i + 1));
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = memorize(s1, s2, i - 1, j - 1, dp);
        }
        return dp[i][j] = Math.min(s1.charAt(i) + memorize(s1, s2, i - 1, j, dp),
                s2.charAt(j) + memorize(s1, s2, i, j - 1, dp));
    }

    private int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // recursion
        System.out.println(f(s1, s2, m - 1, n - 1));

        // memorization
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        memorize(s1, s2, m - 1, n - 1, dp);
        System.out.println(dp[m - 1][n - 1]);

        // tabulation
        dp = new int[m + 1][n + 1];
        // initialize first column with s1 values
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        // initialize first row with s2 values
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j],
                            s2.charAt(j - 1) + dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        System.out.println(new MinimumASCIIDeleteSumForTwoStrings().minimumDeleteSum(s1, s2));
    }
}
