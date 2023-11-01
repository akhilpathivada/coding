/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Time Complexity: O(log(N))
 * Space Complexity: O(1)
 * */
package binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElement {

    private int findStartingIndex(int[] nums, int target) {
        int startingIndex = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int midpoint = start + (end - start) / 2;
            if (nums[midpoint] >= target) {
                end = midpoint - 1;
            } else {
                start = midpoint + 1;
            }
            // even if we find the target : we still look for it's starting index
            if (nums[midpoint] == target) {
                startingIndex = midpoint;
            }
        }
        return startingIndex;
    }

    private int findEndingIndex(int[] nums, int target) {
        int endingIndex = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int midpoint = start + (end - start) / 2;
            if (nums[midpoint] <= target) {
                start = midpoint + 1;
            } else {
                end = midpoint - 1;
            }
            // even if we find the target : we still look for it's ending index
            if (nums[midpoint] == target) {
                endingIndex = midpoint;
            }
        }
        return endingIndex;
    }

    private int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = findStartingIndex(nums, target);
        range[1] = findEndingIndex(nums, target);
        return range;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElement().searchRange(nums, target)));
    }
}
