/**
 * https://leetcode.com/problems/subsets/description/
 *
 * Time Complexity: O(2 ^ N)
 * Space Complexity: O(N)
 * */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {

    private void subsets(int[] nums, List<Integer> subset, List<List<Integer>> result, int index) {
        // add the current subset to result
        result.add(new ArrayList<>(subset));
        // generate subsets by recursively including and
        // excluding elements
        for (int i = index; i < nums.length; ++i) {
            // add the current element to subset
            subset.add(nums[i]);
            // recursively generate subsets with the current
            // element included
            subsets(nums, subset, result, i + 1);
            // exclude the current element from the subset and backtrack
            subset.remove(subset.size() - 1);
        }
    }

    private List<List<Integer>> subsets(int[] nums) {
        // store the current subset
        List<Integer> subset = new ArrayList<>();
        // store all the subsets
        List<List<Integer>> result = new ArrayList<>();

        subsets(nums, subset, result, 0);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(new GenerateSubsets().subsets(nums));
    }
}
