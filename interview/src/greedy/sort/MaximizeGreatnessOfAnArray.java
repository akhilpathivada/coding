/**
 * author: akhilpathivada
 * time: 18/06/24 15:29
 *
 * https://leetcode.com/problems/maximize-greatness-of-an-array/description/
 *
 */
package greedy.sort;

import java.util.Arrays;

public class MaximizeGreatnessOfAnArray {

    private int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int num : nums) {
            if (num > nums[count]) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 1, 3, 1};
        System.out.println(new MaximizeGreatnessOfAnArray().maximizeGreatness(nums));
    }
}
