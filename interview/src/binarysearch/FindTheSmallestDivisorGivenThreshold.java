/**
 * Date 12/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 */
package binarysearch;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenThreshold {

    private boolean canBeSmallestDivisor(int[] nums, int threshold, int divisor) {
        int result = 0;
        for (int num : nums) {
            result += (int) Math.ceil((double) num / divisor);
        }
        return result <= threshold;
    }

    private int smallestDivisor(int[] nums, int threshold) {
        // min. possible divisor
        int low = 0;
        // max. possible divisor
        int high = Arrays.stream(nums).max().getAsInt();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canBeSmallestDivisor(nums, threshold, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {44, 22, 33, 11, 1};
        int threshold = 5;
        System.out.println(new FindTheSmallestDivisorGivenThreshold().smallestDivisor(nums, threshold));
    }
}
