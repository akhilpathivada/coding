/**
 * https://leetcode.com/problems/wildcard-matching/description/
 *
 * Time Complexity: O(N * P)
 * Space Complexity: O(N * P)
 * */
package dp;

public class WildcardMatching {

    private boolean isMatch(String s, String p) {
        char[] text = s.toCharArray(), pattern = p.toCharArray();
        int m = s.length();
        int n = 0;
        boolean firstVisit = true;
        // if there are multiple '*' in pattern
        // replace them with single '*'
        // a***b**c -> a*b*c
        for (int i = 0; i < pattern.length; ++i) {
            if (pattern[i] == '*') {
                if (firstVisit) {
                    pattern[n++] = pattern[i];
                    firstVisit = false;
                }
            } else {
                pattern[n++] = pattern[i];
                firstVisit = true;
            }
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        if (n > 0 && pattern[0] == '*') {
            dp[0][1] = true;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if ((pattern[j - 1] == text[i - 1]) || pattern[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa", p = "a*";
        System.out.println(new WildcardMatching().isMatch(s, p));
        s = "cb";
        p = "?a";
        System.out.println(new WildcardMatching().isMatch(s, p));
    }
}
