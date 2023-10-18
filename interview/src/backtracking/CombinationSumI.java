/**
 * https://leetcode.com/problems/combination-sum/description/
 *
 * Time Complexity: O(k*(2^n)) where n is the size of array, and k is average length
 * Space Complexity: O(k*x) where is x is number of possible combinations
 * */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int[] candidates, int currentSum,
            int target, int currentIndex) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = currentIndex; i < candidates.length; ++i) {
            combination.add(candidates[i]);
            currentSum += candidates[i];
            // we can repeat the same element again : so backtracking with same
            backtrack(result, combination, candidates, currentSum, target, i);
            combination.remove(combination.size() - 1);
            currentSum -= candidates[i];
        }
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, 0, target, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(new CombinationSumI().combinationSum(candidates, target));
    }
}
