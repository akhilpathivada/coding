/**
 * https://leetcode.com/problems/combinations/description/
 *
 * Time Complexity: O(2^n))
 * Space Complexity: O(2^k)
 * */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int n, int k, int start) {
        // got a combination with size k
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n; ++i) {
            // add to current combination
            combination.add(i);
            // backtrack with next elements
            backtrack(result, combination, n, k, i + 1);
            // remove from current combination
            combination.remove(combination.size() - 1);
        }
    }

    private List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(new Combinations().combine(n, k));
    }
}
