/**
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * Time Complexity: O(N * P)
 * Space Complexity: O(N * P)
 * */
package dp;

public class RegularExpressionMatching {

    private boolean isMatch(String s, String p) {
        char[] text = s.toCharArray(), pattern = p.toCharArray();
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // to deal with pattern like a* or a*b* or a*b*c*
        for (int i = 1; i <= n; ++i) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if ((pattern[j - 1] == text[i - 1]) || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    // 0 occurence
                    dp[i][j] = dp[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
        s = "aa";
        p = "*";
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }
}
