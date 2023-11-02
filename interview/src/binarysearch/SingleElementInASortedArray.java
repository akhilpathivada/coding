/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package binarysearch;

public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == low || mid == high) {
                return nums[mid];
            }
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(nums));
    }
}
