/**
 * author: akhilpathivada
 * time: 09/06/24 07:26
 *
 * https://leetcode.com/problems/ways-to-split-array-into-good-subarrays/description/
 *
 */
package dp.coinchange;

import java.util.Arrays;

public class WaysToSplitArrayIntoGoodSubarrays {

    private final int MOD = (int) 1e9 + 7;

    private int f(int[] nums, int index, int sum) {
        if (index < 0) {
            return sum;
        }
        sum += nums[index];
        if (sum > 1) {
            return 0;
        }
        int pick = f(nums, index - 1, sum);
        int skip = sum == 1 ? f(nums, index - 1, 0) : 0;
        return (pick + skip) % MOD;
    }

    private int memoize(int[] nums, int[][] dp, int index, int sum) {
        if (index < 0) {
            return sum;
        }
        sum += nums[index];
        if (sum > 1) {
            return 0;
        }
        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }
        int pick = memoize(nums, dp, index - 1, sum);
        int skip = sum == 1 ? memoize(nums, dp, index - 1, 0) : 0;
        return dp[index][sum] = (pick + skip) % MOD;
    }

    private int numberOfGoodSubarraySplits(int[] nums) {
        final int n = nums.length;
        // recursion
        System.out.println(f(nums, n - 1, 0));

        // memoization
        final int[][] dp = new int[n][2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return memoize(nums, dp, n - 1, 0);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 1};
        System.out.println(new WaysToSplitArrayIntoGoodSubarrays().numberOfGoodSubarraySplits(nums));
    }
}
