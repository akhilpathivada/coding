/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/longest-decreasing-subsequence/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package dp.lis;

import java.util.Arrays;

public class LongestDecreasingSubsequence {
        private int LDS(int[] nums, int n) {
                // store longest decreasing sequence till that point
                int[] lds = new int[n];
                for (int i = 0; i < n; ++i) {
                        lds[i] = 1;
                        // iterate over previous elements and check adding current element
                        // to its sequence can increase result
                        for (int j = 0; j < i; ++j) {
                                if (nums[i] < nums[j] && lds[j] + 1 > lds[i]) {
                                        lds[i] = lds[j] + 1;
                                }
                        }
                }
                // return the maximum from lis[]
                return Arrays.stream(lds).max().getAsInt();
        }
        public static void main(String[] args) {
                int[] nums = { 15, 27, 14, 38, 63, 55, 46, 65, 85 };
                System.out.printf("Length of LDS is = %d ", new LongestDecreasingSubsequence().LDS(nums, nums.length));
        }
}
