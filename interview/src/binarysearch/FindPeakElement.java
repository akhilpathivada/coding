/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Time Complexity: O(log(N))
 * Space Complexity: O(1)
 * */
package binarysearch;

public class FindPeakElement {

    private int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // if the mid is in a decreasing part
            // this might be the answer
            // now go to left if there exist any greater value
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else { // you are in ascending order
                // go to right if there exist greater value
                start = mid + 1;
            }
        }
        // at the end, start and end will be at same point
        return start;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }
}
