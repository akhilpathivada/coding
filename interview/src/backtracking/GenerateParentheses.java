/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Time Complexity: O(2 ^ N)
 * Space Complexity: O(N)
 * */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private void backtrack(List<String> output, String currentCombination, int open, int close, int max) {
        // base case
        if (currentCombination.length() == max * 2) {
            output.add(currentCombination);
            return;
        }
        if (open < max) { // if we can still add open parenthesis
            backtrack(output, currentCombination + "(", open + 1, close, max);
        }
        if (close < open) { // if we can still add close parenthesis
            backtrack(output, currentCombination + ")", open, close + 1, max);
        }
    }

    private List<String> generateParentheses(int n) {
        // to store output
        List<String> output = new ArrayList<>();
        backtrack(output, "", 0, 0, n);
        return output;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GenerateParentheses().generateParentheses(n));
    }
}
