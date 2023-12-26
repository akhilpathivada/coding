/**
 * @author akhilpathivada
 * <p>
 * date : 26/12/23
 * time: 16:01
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 *
 */
package binarysearch;

public class MinimumInRotatedSortedArrayII {

    private int findMin(int[] nums) {
        int n = nums.length;
        // base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int left = 0, right = n - 1;
        // find the pivot index : that is the place where rotation happened
        // elements before and after pivot point are sorted.
        // min will be the next one of pivot
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                --right;
            }
        }
        return nums[left % n];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 0, 1 };
        System.out.println(new MinimumInRotatedSortedArrayII().findMin(nums));
    }
}
