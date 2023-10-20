/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package array;

public class FirstMissingPositiveII {

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private int firstMissingPositive(int[] nums) {

        int n = nums.length;
        // case-1: leave negative elements same
        // case-2: if element is greater than 'n-1', leave them same
        // case-3: let's place element at it's index position - means place '2' at index '2'
        for (int i = 0; i < n; ++i) {
            // since because array index starts with 0
            // means number 3 should go to index 2
            int correctPosition = nums[i] - 1;
            // nums[i] should be positive
            // nums[i] shouldn't exceed 'n'
            // nums[i] shouldn't have a duplicate
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctPosition]) {
                swap(nums, i, correctPosition);
                correctPosition = nums[i] - 1;
            }
        }
        // find the first index 'i' that doesn't have 'i' as it's value
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = { -1, -2, -60, 40, 43 };
        System.out.println(new FirstMissingPositiveII().firstMissingPositive(nums));
    }
}
