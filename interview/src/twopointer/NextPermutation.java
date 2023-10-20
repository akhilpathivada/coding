/**
 * https://leetcode.com/problems/next-permutation/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package twopointer;

import java.util.Arrays;

public class NextPermutation {

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // store the break point
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }
        // now find the element first greater element than the break point element
        int j = nums.length - 1;
        if (i >= 0) {
            while (nums[j] <= nums[i]) {
                --j;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 2 };
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
