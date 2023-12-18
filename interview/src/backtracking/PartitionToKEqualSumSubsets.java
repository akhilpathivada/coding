/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * Time Complexity: O(2 ^ (N * K))
 * */
package backtracking;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

    private boolean backtrack(int[] nums, boolean[] taken, int index, int k, int subsetSum, int target) {
        // base case
        if (k == 0) {
            return true;
        }
        // we found a subset for the target.
        // and now we move on to find the next subset
        if (subsetSum == target) {
            backtrack(nums, taken, 0, k - 1, 0, target);
        }
        // backtrack
        for (int i = index; i < nums.length; ++i) {
            // if number is already visited or sum is out of range then skip
            if (taken[i] || subsetSum + nums[i] > target) {
                continue;
            }
            taken[i] = true;
            if (backtrack(nums, taken, i + 1, k, subsetSum + nums[i], target)) {
                return true;
            }
            taken[i] = false;
        }
        return false;
    }

    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        // if the total sum can't be partitioned into k equal sum subsets
        if (totalSum % k != 0) {
            return false;
        }
        // keep track the element has been used in any on the valid partitions
        boolean[] taken = new boolean[nums.length];
        int target = totalSum / k;
        return backtrack(nums, taken, 0, k, 0, target);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
        int k = 4;
        System.out.println(new PartitionToKEqualSumSubsets().canPartitionKSubsets(nums, k));
    }
}
