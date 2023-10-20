/**
 * Date 09/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/house-robber-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package dp;

public class HouseRobberII {

    private int rob1(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; ++i) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end];
    }

    private int rob2(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; ++i) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end];
    }

    private int rob(int nums[], int n) {
        // base case
        if (n == 0 || n == 2) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Math.max(rob1(nums, 0, n - 2), rob2(nums, 1, n - 1));
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println("Max amount you can rob = " + new HouseRobberII().rob(nums, nums.length));
    }
}
