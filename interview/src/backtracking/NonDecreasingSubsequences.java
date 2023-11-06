/**
 * https://leetcode.com/problems/non-decreasing-subsequences/description/
 * */
package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {

    private void backtrack(int[] nums, List<Integer> sequence, Set<List<Integer>> set, int index, int prev) {
        // add the current subset to result
        if (sequence.size() > 1) {
            if (!set.contains(sequence)) {
                set.add(new ArrayList<>(sequence));
            }
        }
        // generate subsets by recursively including and
        // excluding elements
        for (int i = index; i < nums.length; ++i) {
            // recursively generate subsets with the current
            // element included
            if (nums[i] >= prev) {
                // add the current element to subset
                sequence.add(nums[i]);
                backtrack(nums, sequence, set, i + 1, nums[i]);
                // exclude the current element from the subset and backtrack
                sequence.remove(sequence.size() - 1);
            }
        }
    }

    private List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(nums, new ArrayList<>(), set, 0, Integer.MIN_VALUE);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 6, 7, 7 };
        System.out.println(new NonDecreasingSubsequences().findSubsequences(nums));
    }
}
