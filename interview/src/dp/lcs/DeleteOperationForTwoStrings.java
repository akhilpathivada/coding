/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * */
package dp.lcs;

public class DeleteOperationForTwoStrings {

    private int minDelete(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();
        final int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1)
                        ? 1 + dp[i - 1][j - 1]
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }
        // remove the LCS length from both strings
        return word1.length() - dp[m][n] + word2.length() - dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(new DeleteOperationForTwoStrings().minDelete(word1, word2));
    }
}
