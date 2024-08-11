/**
 * author: akhilpathivada
 * time: 11/08/24 20:32
 *
 * https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
 *
 */
package slidingwindow;

import java.util.Arrays;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

    private int minOperations(int[] nums) {
        int operations = 0;
        for (int i = 0, j = 2; j < nums.length; ++i, ++j) {
            if (nums[i] == 0) {
                ++operations;
                for (int k = i; k < i + 3; ++k) {
                    nums[k] = nums[k] == 0 ? 1 : 0;
                }
            }
        }
        return Arrays.stream(nums).filter(num -> num == 0).findFirst().isPresent() ? -1 : operations;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 0};
        System.out.println(new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI().minOperations(nums));
    }
}
