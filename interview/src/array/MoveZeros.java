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

        int temp = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (temp == -1 && nums[i] == 0) {
                temp = i;
            } else if (temp != -1 && nums[i] != 0) {
                nums[temp] = nums[i];
                nums[i] = 0;
                i = temp;
                temp = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 0, 12 };
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}
