/**
 * https://leetcode.com/problems/target-sum/description/
 * */
package dp.coinchange;

public class TargetSum {

    private int f(int[] nums, int target, int n) {
        // base case
        if (n == 0) {
            return (Math.abs(target - nums[0]) == 0) ? 1 : 0;
        }
        int taken = 0;
        if (nums[n] <= target) {
            taken = f(nums, target + n, n - 1) + f(nums, target - n, n - 1);
        }
        int notTaken = f(nums, target, n - 1);
        return taken + notTaken;
    }

    private int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        System.out.println(f(nums, target, n - 1));
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(new TargetSum().findTargetSumWays(nums, target));
    }
}
