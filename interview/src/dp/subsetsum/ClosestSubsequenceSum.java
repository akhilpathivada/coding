/**
 * Date 05/04/24
 *
 * @author akhilpathivada
 */

package dp;

import java.util.Arrays;

public class ClosestSubsequenceSum {

    private int f(int[] nums, int goal, int sum, int i) {
        // base case
        if (i < 0) {
            return Math.abs(goal - sum);
        }
        return Math.min(f(nums, goal, sum, i - 1), f(nums, goal, sum + nums[i], i - 1));
    }

    private int memorize(int[] nums, int[][] dp, int goal, int sum, int i) {
        // base case
        if (i < 0) {
            return Math.abs(goal - sum);
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        return dp[i][sum] = Math.min(f(nums, goal, sum, i - 1), f(nums, goal, sum + nums[i], i - 1));
    }


    private int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        System.out.println(f(nums, goal, 0, n - 1));
        // memorization
        int[][] dp = new int[n][100000001];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return memorize(nums, dp, goal, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {7,-9,15,-2}; int goal = -5;
        System.out.println(new ClosestSubsequenceSum().minAbsDifference(nums, goal));
    }
}
