/**
 * author: akhilpathivada
 * time: 18/06/24 15:52
 *
 * https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
 *
 */
package greedy.sorting;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

    private int[] answerQueries(int[] nums, int[] queries) {
        final int n = queries.length;
        final int[] result = new int[n];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < n; ++i) {
            result[i] = Math.abs(Arrays.binarySearch(nums, queries[i]) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        System.out.println(Arrays.toString(new LongestSubsequenceWithLimitedSum().answerQueries(nums, queries)));
    }
}
