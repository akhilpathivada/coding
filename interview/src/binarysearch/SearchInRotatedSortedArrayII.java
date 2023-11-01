/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package binarysearch;

public class SearchInRotatedSortedArrayII {

    private boolean search(int[] nums, int target) {
        int n = nums.length;
        // base case
        if (n == 0) {
            return false;
        }
        int left = 0, right = n - 1;
        // find the pivot index : that is the place where rotation happened
        // elements before and after pivot point are sorted.
        // target will be in one of the sorted arrays
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // shrink the array from both sides
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                ++left;
                --right;
                continue;
            }
            // the left part
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) { // element exists
                    right = mid - 1;
                } else { // element not exists
                    left = mid + 1;
                }
            } else { // the right part
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 1 };
        int target = 0;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));
        int[] nums2 = { 2, 2, 2, 3, 2, 2, 2 };
        target = 3;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums2, target));
        int[] nums3 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 };
        target = 2;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums3, target));
    }
}
