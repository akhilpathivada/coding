/**
 * @author akhilpathivada
 * <p>
 * date : 21/03/24
 * time: 05:52
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package twopointer;

import java.util.Arrays;

public class TwoSumII {

    private int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum < target) {
                ++left;
            } else {
                --right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(new TwoSumII().twoSum(nums, target)));
    }
}
