/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package array;

import java.util.Arrays;

public class MoveZeros {

    private static void moveZeros(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return;
        }
        int insertPosition = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPosition++] = num;
            }
        }
        while (insertPosition < n) {
            nums[insertPosition++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 0, 12 };
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}
