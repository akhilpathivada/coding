/**
 * author: akhilpathivada
 * time: 04/10/24 06:55
 *
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/description/
 *
 */
package twopointer;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    private int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                ++result;
                ++left;
                --right;
            } else if (sum < k) {
                ++left;
            } else {
                --right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        System.out.println(new MaxNumberOfKSumPairs().maxOperations(nums, k));
    }
}
