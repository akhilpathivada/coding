/**
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * Time Complexity: O(n * target)
 * Space Complexity: O(n * target)
 * */
package dp.coinchange;

import java.util.Arrays;

public class CombinationSumIV {

    // recursive approach
    private int f(int[] nums, int target) {
        // base case
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int num : nums) {
            if (target - num >= 0) {
                count += f(nums, target - num);
            }
        }
        return count;
    }

    // top-down approach
    private int topDown(int[] nums, int target, int[] dp) {
        // base case
        if (target == 0) {
            return 1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int count = 0;
        for (int num : nums) {
            if (target - num >= 0) {
                count += topDown(nums, target - num, dp);
            }
        }
        return dp[target] = count;
    }

    private int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        // recursive solution
        System.out.println(f(nums, target));
        // top down solution
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        System.out.println(topDown(nums, target, dp));
        // tabulation
        dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            int count = 0;
            for (int num : nums) {
                if (i - num >= 0) {
                    count += dp[i - num];
                }
            }
            dp[i] = count;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;
        System.out.println(new CombinationSumIV().combinationSum4(nums, target));
    }
}
