/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package strings;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    private int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int countOfUnbalancedClosedParentheses = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    ++countOfUnbalancedClosedParentheses;
                }
            }
        }
        return stack.size() + countOfUnbalancedClosedParentheses;
    }

    public static void main(String[] args) {
        String s = "(((";
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s));
    }
}
