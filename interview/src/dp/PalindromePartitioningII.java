/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N)
 * */
package dp;

public class PalindromePartitioningII {

    private boolean isPalindrome(String s, int a, int b) {
        while (a < b) {
            if (s.charAt(a++) != s.charAt(b--)) {
                return false;
            }
        }
        return true;
    }

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

    private int minCut(String s) {
        // recursive solution
        int recursion = f(s, s.length(), 0) - 1;
        // from tabulation
        int n = s.length();
        int[] dp = new int[n + 1];
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
