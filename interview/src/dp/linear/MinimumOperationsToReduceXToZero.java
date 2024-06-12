/**
 * author: akhilpathivada
 * time: 12/06/24 14:36
 *
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/
 *
 */
package dp.linear;

import java.util.Arrays;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {

    private int f(int[] nums, int x, int start, int end) {
        if (x == 0) {
            return 0;
        }
        if (x < 0 || start > end || start < 0 || end < 0 || start > nums.length - 1 || end > nums.length - 1) {
            return Integer.MAX_VALUE;
        }
        return 1 + Math.min(f(nums, x - nums[start], start + 1, end),
                f(nums, x - nums[end], start, end - 1));
    }

    private int memoize(int[] nums, int x, int start, int end, int[][] dp) {
        if (x == 0) {
            return 0;
        }
        if (x < 0 || start > end || start < 0 || end < 0 || start > nums.length - 1 || end > nums.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        return dp[start][end] = 1 + Math.min(memoize(nums, x - nums[start], start + 1, end, dp),
                memoize(nums, x - nums[end], start, end - 1, dp));
    }

    private int minOperations(int[] nums, int x) {
        final int n = nums.length;
        int result = f(nums, x, 0, n - 1);
        final int[][] dp = new int[n + 2][n + 2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        result = memoize(nums, x, 0, n - 1, dp);
        return result == Integer.MIN_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 20, 1, 1, 3};
        int x = 10;
        System.out.println(new MinimumOperationsToReduceXToZero().minOperations(nums, x));
    }
}
