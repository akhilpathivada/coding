/**
 * https://leetcode.com/problems/target-sum/description/
 * */
package dp.coinchange;

public class TargetSum {

    private int f(int[] nums, int target, int n, int sum) {
        if (n < 0) {
            return sum == target ? 1 : 0;
        }
        return f(nums, target, n - 1, sum + nums[n]) + f(nums, target, n - 1, sum - nums[n]);
    }

    private int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        System.out.println(f(nums, target, n - 1, 0));
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(new TargetSum().findTargetSumWays(nums, target));
    }
}
