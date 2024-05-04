/**
 * author: akhilpathivada
 * time: 03/05/24 07:41
 *
 * https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/description/
 *
 */
package dp.coinchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfTheLongestSubsequenceThatSumsToTarget {

    private int f(List<Integer> nums, int target, int n) {
        if (target == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        int lengthIfPick = Integer.MIN_VALUE;
        if (nums.get(n) <= target) {
            lengthIfPick = 1 + f(nums, target - nums.get(n), n - 1);
        }
        int lengthIfSkip = f(nums, target, n - 1);
        return Math.max(lengthIfPick, lengthIfSkip);
    }

    private int memoize(List<Integer> nums, int target, int[][] dp, int n) {
        if (target == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        int lengthIfPick = Integer.MIN_VALUE;
        if (nums.get(n) <= target) {
            lengthIfPick = 1 + memoize(nums, target - nums.get(n), dp, n - 1);
        }
        int lengthIfSkip = memoize(nums, target, dp, n - 1);
        return dp[n][target] = Math.max(lengthIfPick, lengthIfSkip);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        final int n = nums.size();
        int result;
        // recursion
        // result = f(nums, target, n - 1);

        // memoization
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        result = memoize(nums, target, dp, n - 1);

        // tabulation
        dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= target; ++j) {
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int lengthIfPick = Integer.MIN_VALUE;
                if (nums.get(i) <= target) {
                    lengthIfPick = 1 + dp[i - 1][target - nums.get(i)];
                }
                int lengthIfSkip = dp[i - 1][target];
                dp[i][j] = Math.max(lengthIfPick, lengthIfSkip);
            }
        }
        result = dp[n - 1][target];
        return result < 0 ? -1 : result;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(4, 1, 3, 2, 1, 5));
        int target = 7;
        System.out.println(new LengthOfTheLongestSubsequenceThatSumsToTarget().lengthOfLongestSubsequence(nums, target));
    }
}
