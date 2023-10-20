/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/permutations/
 *
 * Time Complexity: O(n * n!)
 * Space Complexity : O(n)
 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> permutation, boolean[] seen) {
        // base case
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (seen[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !seen[i - 1]) {
                    continue;
                }
                seen[i] = true;
                permutation.add(nums[i]);
                backtrack(nums, result, permutation, seen);
                permutation.remove(permutation.size() - 1);
                seen[i] = false;
            }
        }
    }

    private List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(new PermutationsII().permuteUnique(nums));
    }
}
