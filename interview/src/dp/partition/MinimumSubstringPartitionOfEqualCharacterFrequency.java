/**
 * author: akhilpathivada
 * time: 28/05/24 17:05
 *
 * https://leetcode.com/problems/minimum-substring-partition-of-equal-character-frequency/description/
 *
 */
package dp.partition;

import java.util.Arrays;

public class MinimumSubstringPartitionOfEqualCharacterFrequency {

    private boolean isBalanced(String s) {
        final int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int min = s.length();
        for (int f : freq) {
            if (f > 0) {
                min = Math.min(min, f);
            }
        }
        return min == Arrays.stream(freq).max().getAsInt();
    }

    private int f(String s, int i, int n) {
        if (i == n) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; ++j) {
            if (isBalanced(s.substring(i, j + 1))) {
                min = Math.min(min, 1 + f(s, j + 1, n));
            }
        }
        return min;
    }

    private int memoize(String s, int[] dp, int i, int n) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; ++j) {
            if (isBalanced(s.substring(i, j + 1))) {
                min = Math.min(min, 1 + memoize(s, dp, j + 1, n));
            }
        }
        return dp[i] = min;
    }

    private int minimumSubstringsInPartition(String s) {
        final int n = s.length();

        // recursion
        // System.out.println(f(s, 0, n));

        // memoization
        final int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return memoize(s, dp, 0, n);
    }

    public static void main(String[] args) {
        String s = "fabccddg";
        System.out.println(new MinimumSubstringPartitionOfEqualCharacterFrequency().minimumSubstringsInPartition(s));
    }
}
