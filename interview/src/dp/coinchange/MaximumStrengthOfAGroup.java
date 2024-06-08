/**
 * author: akhilpathivada
 * time: 08/06/24 09:30
 *
 * https://leetcode.com/problems/maximum-strength-of-a-group/description/
 *
 */
package dp.coinchange;

import java.util.Arrays;

public class MaximumStrengthOfAGroup {

    private long f(int[] nums, int index, boolean anyNumTaken, long product) {
        if (index == nums.length) {
            return anyNumTaken ? product : Integer.MIN_VALUE;
        }
        return Math.max(f(nums, index + 1, true, product * nums[index]),
                f(nums, index + 1, anyNumTaken, product));
    }

    private long memoize(int[] nums, long[][] dp, int index, int anyNumTaken, long product) {
        if (index == nums.length) {
            return anyNumTaken == 1 ? product : Integer.MIN_VALUE;
        }
        if (dp[index][0] == -1) {
            dp[index][0] = memoize(nums, dp, index + 1, anyNumTaken, product);
        }
        if (dp[index][1] == -1) {
            dp[index][1] = memoize(nums, dp, index + 1, 1, product * nums[index]);
        }
        return Math.max(dp[index][0], dp[index][1]);
    }

    private long maxStrength(int[] nums) {
        // recursion
        System.out.println(f(nums, 0, false, 1));

        // memoization
        final long[][] dp = new long[nums.length][2];
        for (long[] d : dp) {
            Arrays.fill(d, -1);
        }
        memoize(nums, dp, 0, 0, 1);
        System.out.println(Arrays.deepToString(dp));
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, -1, -5, 2, 5, -9};
        System.out.println(new MaximumStrengthOfAGroup().maxStrength(nums));
    }
}
