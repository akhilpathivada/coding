/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/contiguous-array/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package prefixsum;

import java.util.HashMap;

public class MaximumLengthOfSubarrayWithEqualZerosOnes {
        private int findMaxLength(int[] nums, int n) {
                // make all 0s to -1
                for (int i = 0; i < n; ++i) {
                        if (nums[i] == 0) {
                                nums[i] = -1;
                        }
                }
                int prefixSum = 0, max = 0;
                // store the map
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, -1);
                for (int i = 0; i < n; ++i) {
                        prefixSum += nums[i];
                        // found, update the length
                        if (map.containsKey(prefixSum)) {
                                max = Math.max(i - map.get(prefixSum), max);
                        } else {
                                map.put(prefixSum, i);
                        }
                }
                return max;
        }
        public static void main(String[] args) {
                int[] nums = { 0, 1, 0, 0, 1, 1, 0};
                System.out.println("Length of largest subarray with equal 0s 1s = " + new MaximumLengthOfSubarrayWithEqualZerosOnes().findMaxLength(nums, nums.length));
        }
}
