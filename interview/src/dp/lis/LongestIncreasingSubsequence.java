/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package dp.lis;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

        private int lengthOfLIS(int[] nums) {
                int n = nums.length;
                // store longest increasing sequence till that point
                int[] lis = new int[n];
                for (int i = 0; i < n; ++i) {
                        lis[i] = 1;
                        // iterate over previous elements and check adding current element
                        // to its sequence can increase result
                        for (int j = 0; j < i; ++j) {
                                if (nums[i] > nums[j] && lis[j] + 1 > lis[i]) {
                                        lis[i] = lis[j] + 1;
                                }
                        }
                }
                // return the maximum from lis[]
                return Arrays.stream(lis).max().getAsInt();
        }

        public static void main(String[] args) {
                int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60 };
                System.out.printf("Longest Increasing Subsequence : %d ", new LongestIncreasingSubsequence().lengthOfLIS(nums));
        }
}
