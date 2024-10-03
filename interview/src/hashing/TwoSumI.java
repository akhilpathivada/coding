/**
 * https://leetcode.com/problems/two-sum/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 * */
package hashing;

import java.util.Arrays;

public class TwoSumI {

        private int[] twoSum(int[] nums, int target) {
                final int n = nums.length;
                for (int i = 0; i < n; ++i) {
                        for (int j = i + 1; j < n; ++j) {
                                if (nums[i] + nums[j] == target) {
                                        return new int[]{i, j};
                                }
                        }
                }
                return null;
        }

        public static void main(String[] args) {
                int[] nums = {2, 7, 11, 15};
                int target = 22;
                System.out.println(Arrays.toString(new TwoSumI().twoSum(nums, target)));
        }
}
