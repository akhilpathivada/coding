/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package dp.lis;

import java.util.Arrays;

public class LongestIncreasingSubsequenceCount {

    private int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // base case
        if (n == 1) {
            return n;
        }
        // stores the length of longest increasing sequence ends at a certain position
        int[] lis = new int[n];
        // stores the count of longest increasing sequences ends at a certain position
        int[] count = new int[n];
        for (int i = 0; i < n; ++i) {
            lis[i] = 1;
            count[i] = 1;
            // iterate over previous elements and check adding current element
            // to its sequence can increase result
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    // inherit the count
                    count[i] = count[j];
                } else if (nums[i] > nums[j] && lis[j] + 1 == lis[i]) {
                    // increase the count
                    count[i] += count[j];
                }
            }
        }
        // get the maximum from lis[]
        int maxLength = Arrays.stream(lis).max().getAsInt();
        int numberOfLIS = 0;
        for (int i = 0; i < n; ++i) {
            if (lis[i] == maxLength) {
                numberOfLIS += count[i];
            }
        }
        return numberOfLIS;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(new LongestIncreasingSubsequenceCount().findNumberOfLIS(nums));
    }
}
