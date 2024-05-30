package dp.partition;

import java.util.Arrays;

/**
 * Date 06/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/partition-string-into-minimum-beautiful-substrings/description/
 *
 */
public class PartitionStringIntoMinimumBeautifulSubstrings {

    private boolean isBeautiful(String s, int start, int end) {
        if (s.charAt(start) == '0') {
            return false;
        }
        int num = 0;
        int curr = 1;
        // convert to decimal
        for (int i = end; i >= start; i--) {
            if (s.charAt(i) == '1') {
                num += curr;
            }
            curr = curr * 2;
        }
        // is power of 5 (simple way)
        return 15625 % num == 0;
    }

    private int f(String s, int n, int i) {
        // base case
        if (i == n) {
            return 0;
        }
        int min = Integer.MAX_VALUE - 1;
        int num = 0;
        // number[i...j]
        for (int j = i; j < n; ++j) {
            num = num * 2 + s.charAt(j) - '0';
            if (isBeautiful(s, i, j)) {
                min = Math.min(min, 1 + f(s, n, j + 1));
            }
        }
        return min;
    }

    private int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        // recursive solution
        System.out.println(f(s, n, 0));

        // tabulation
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            for (int j = i; j < n; j++) {
                if (isBeautiful(s, i, j)) {
                    dp[j + 1] = Math.min(dp[j + 1], 1 + dp[i]);
                }
            }
        }
        return dp[n] > n ? -1 : dp[n];
    }

    public static void main(String[] args) {
        String s = "1011";
        System.out.println(new PartitionStringIntoMinimumBeautifulSubstrings().minimumBeautifulSubstrings(s));
    }
}
