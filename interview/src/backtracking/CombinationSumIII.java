/**
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * Time Complexity: O(k*(2^n)) where n is the size of array, and k is average length
 * Space Complexity: O(k*x) where is x is number of possible combinations
 * */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int n, int currentSum,
            int currentNumber) {
        // base case
        if (currentSum > n || combination.size() > k) {
            return;
        }
        if (currentSum == n && combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = currentNumber; i <= 9; ++i) {
            combination.add(i);
            currentSum += i;
            // we can repeat the same element again : so backtrack with next element
            backtrack(result, combination, k, n, currentSum, i + 1);
            combination.remove(combination.size() - 1);
            currentSum -= i;
        }
    }

    private List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 0, 1);
        return result;
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(new CombinationSumIII().combinationSum(k, n));
    }
}
