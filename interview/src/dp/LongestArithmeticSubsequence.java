/**
 * https://leetcode.com/problems/longest-arithmetic-subsequence/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * */
package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

    private int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        int result = 0;
        for (int i = 0; i < n; ++i) {
            // max. length arithmetic sequence ends here
            dp[i] = new HashMap<>();
            // find the diff of this element from its previous elements
            // and for every diff obtained : capture them into map
            for (int j = 0; j < i; ++j) {
                int diff = nums[j] - nums[i];
                // put the diff and length of the arithmetic sequence so far with this diff
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                // capture the max length of arithmetic sequence
                result = Math.max(result, dp[i].get(diff));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 20, 1, 15, 3, 10, 5, 8 };
        System.out.println(new LongestArithmeticSubsequence().longestArithSeqLength(nums));
    }
}
