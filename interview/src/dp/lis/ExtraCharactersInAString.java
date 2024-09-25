/**
 * author: akhilpathivada
 * time: 25/09/24 08:16
 *
 * https://leetcode.com/problems/extra-characters-in-a-string/description/
 *
 */
package dp.lis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharactersInAString {

    // similar to: https://leetcode.com/problems/word-break/
    private int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();
        final int[] dp = new int[n + 1];
        final Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j <= i; ++j) {
                if (dictionarySet.contains(s.substring(i - j, i))) {
                    dp[i] = Math.min(dp[i], dp[i - j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "sayhelloworld";
        String[] dictionary = {"hello", "world"};
        System.out.println(new ExtraCharactersInAString().minExtraChar(s, dictionary));
    }
}
