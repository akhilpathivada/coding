/**
 * author: akhilpathivada
 * time: 05/06/24 08:26
 *
 * https://leetcode.com/problems/minimum-cost-to-make-array-equal/description/
 *
 */
package binarysearch;

import java.util.Arrays;

public class MinimumCostToMakeArrayEqual {

    private long costToChangeArrayEqualToElement(int[] nums, int[] cost, long target) {
        long totalCost = 0;
        for (int i = 0; i < nums.length; ++i) {
            totalCost += Math.abs(target - nums[i]) * cost[i];
        }
        return totalCost;
    }

    private long minCost(int[] nums, int[] cost) {
        long low = Arrays.stream(nums).min().getAsInt();
        long high = Arrays.stream(nums).max().getAsInt();
        long result = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long cost1 = costToChangeArrayEqualToElement(nums, cost, mid);
            long cost2 = costToChangeArrayEqualToElement(nums, cost, mid + 1);
            if (cost1 < cost2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            result = Math.min(cost1, cost2);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2};
        int[] cost = {2, 3, 1, 14};
        System.out.println(new MinimumCostToMakeArrayEqual().minCost(nums, cost));
    }
}
