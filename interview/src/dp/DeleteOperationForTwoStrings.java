/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * */
package dp;

public class DeleteOperationForTwoStrings {

    private int minDelete(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // find the LCS and then remove the LCS length
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ?
                            1 + dp[i - 1][j - 1] :
                            Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lengthOfLCS = dp[m][n];
        return word1.length() - lengthOfLCS + word2.length() - lengthOfLCS;
    }

    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(new DeleteOperationForTwoStrings().minDelete(word1, word2));
    }
}
