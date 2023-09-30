/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */

package array;

public class MaximumProductSubarray {

    private int maxProduct(int[] nums) {

        int product1 = nums[0]; // keeps track of current max product
        int product2 = nums[0]; // points to a min. number so far
        int result = nums[0]; // the final result

        for (int i = 1; i < nums.length; ++i) {
            // check which inclusion gives max. product at this point
            int temp = Math.max(Math.max(nums[i], product1 * nums[i]), product2 * nums[i]);
            product2 = Math.min(Math.min(nums[i], product1 * nums[i]), product2 * nums[i]);
            product1 = temp;
            result = Math.max(result, product1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }
}
