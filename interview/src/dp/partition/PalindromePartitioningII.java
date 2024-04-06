/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N)
 * */
package dp;

import java.util.Arrays;

public class PalindromePartitioningII {

    private boolean isPalindrome(String s, int a, int b) {
        while (a < b) {
            if (s.charAt(a++) != s.charAt(b--)) {
                return false;
            }
        }
        return true;
    }

    // recursive approach
    private int f(String s, int n, int i) {
        if (i == n) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        // String[i...j]
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + f(s, n, j + 1);
                min = Math.min(min, cost);
            }
        }
        return min;
    }

    // top down approach
    private int memorize(String s, int n, int i, int[] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + memorize(s, n, j + 1, dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min;
    }

    private int minCut(String s) {
        int n = s.length();
        // recursive solution
        System.out.println(f(s, n, 0) - 1);
        // top down solution
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(memorize(s, n, 0, dp) - 1);
        // tabulation
        dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; --i) {
            int min = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; ++j) {
                if (isPalindrome(s, i, j)) {
                    int cost = 1 + dp[j + 1];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }
        return dp[0] - 1;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioningII().minCut(s));
    }
}
