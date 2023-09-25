/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package array;

import java.util.Arrays;

public class FirstMissingPositiveI {

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private int firstMissingPositive(int[] nums, int n) {
        // start from the first positive and
        // make it's index element to it's negative
        for (int i = 0; i < n; ++i) {
            // if index element's position is less than N and
            // the value inside it is positive
            // change it's value to negative
            if (Math.abs(nums[i]) - 1 < n && nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= (-1);
            }
        }
        // find the first index which is having positive
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private int moveNegativeElementsToBeginning(int[] nums) {

        // to track the positive element
        int indexOfFirstPositive = 0;
        for (int i = 0; i < nums.length; i++) {
            // found negative
            if (nums[i] <= 0) {
                swap(nums, indexOfFirstPositive, i);
                ++indexOfFirstPositive;
            }
        }
        return indexOfFirstPositive;
    }

    private int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int indexOfFirstPositive = moveNegativeElementsToBeginning(nums);
        int[] copyOfOnlyPositives = Arrays.copyOfRange(nums, indexOfFirstPositive, n);

        return firstMissingPositive(copyOfOnlyPositives, n - indexOfFirstPositive);
    }

    public static void main(String[] args) {
        int[] nums = { -1, -2, -60, 40, 43 };
        System.out.println(new FirstMissingPositiveI().firstMissingPositive(nums));
    }
}
