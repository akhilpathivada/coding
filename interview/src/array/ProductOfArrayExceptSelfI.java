/**
 * Date 22/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelfI {
        private int[] productExceptSelf(int[] nums) {
                int n = nums.length;
                int[] left = new int[n], right = new int[n];
                Arrays.fill(left, 1);
                Arrays.fill(right, 1);
                for (int i = 1; i < n; ++i) {
                        left[i] = left[i - 1] * nums[i - 1];
                }
                for (int i = n - 2; i >= 0; --i) {
                        right[i] = right[i + 1] * nums[i + 1];
                }
                int[] result = new int[n];
                for (int i = 0; i < n; ++i) {
                        result[i] = left[i] * right[i];
                }
                return result;
        }

        public static void main(String[] args) {
                int[] nums = { 1, 2, 3, 4 };
                System.out.println(Arrays.toString(new ProductOfArrayExceptSelfI().productExceptSelf(nums)));
        }
}
