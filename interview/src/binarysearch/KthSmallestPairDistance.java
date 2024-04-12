/**
 * Date 12/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
 *
 */
package binarysearch;

import java.util.Arrays;

public class KthSmallestPairDistance {

    private int countOfSmallerDistancesThanMid(int[] nums, int dist) {
        int countOfSmallerDistances = 0;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            // if this condition is met: then the current number and all numbers to its right will be greater
            // than dist fom nums[slow] because the array is sorted, so we can just increment slow
            if (nums[fast] - nums[slow] > dist) {
                ++slow;
            } else { // adds the number of pairs between fast and slow
                countOfSmallerDistances += fast - slow;
                ++fast;
            }
        }
        return countOfSmallerDistances;
    }

    private int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        // min. distance
        int low = 0;
        // max. distance
        int high = nums[nums.length - 1] - nums[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countOfSmallerDistancesThanMid(nums, mid) >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 1};
        int k = 3;
        System.out.println(new KthSmallestPairDistance().smallestDistancePair(nums, k));
    }
}
