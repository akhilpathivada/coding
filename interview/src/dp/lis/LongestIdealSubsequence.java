package dp.lis;

import java.util.Arrays;
import java.util.Map;

/**
 * Date 25/04/24
 * Time 17:15
 *
 * @author akhilpathivada
 */
public class LongestIdealSubsequence {

    private int longestIdealString(String s, int k) {
        final int n = s.length();
        final int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (Math.abs(s.charAt(j) - s.charAt(i)) <= k && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        String s = "acfgbd";
        int k = 2;
        System.out.println(new LongestIdealSubsequence().longestIdealString(s, k));
    }
}
