/**
 * author: akhilpathivada
 * time: 08/06/24 07:46
 *
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
 *
 */
package greedy;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    private int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            max = Math.max(max, nums[left++] + nums[right--]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 2, 4, 6};
        System.out.println(new MinimizeMaximumPairSumInArray().minPairSum(nums));
    }
}
