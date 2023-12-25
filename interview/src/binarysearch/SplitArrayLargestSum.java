/**
 * @author akhilpathivada
 * <p>
 * date : 25/12/23
 * time: 07:26
 *
 * https://leetcode.com/problems/split-array-largest-sum/description/
 *
 * Time Complexity:  O(N * log(sum(arr[]) - max(arr[]) + 1))
 * Space Complexity: O(1)
 *
 */
package binarysearch;

import java.util.Arrays;

public class SplitArrayLargestSum {

    private int getNumberOfSplits(int[] nums, int sum) {
        int splits = 1;
        int sumOfTheCurrentSplit = 0;
        for (int num : nums) {
            // add num to current split
            if (sumOfTheCurrentSplit + num <= sum) {
                sumOfTheCurrentSplit += num;
            } else { // go to the next split
                ++splits;
                sumOfTheCurrentSplit = num;
            }
        }
        return splits;
    }

    private int splitArray(int[] nums, int k) {
        // impossible split
        if (k > nums.length) {
            return -1;
        }
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int splits = getNumberOfSplits(nums, mid);
            if (splits > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println(new SplitArrayLargestSum().splitArray(nums, k));
    }
}
