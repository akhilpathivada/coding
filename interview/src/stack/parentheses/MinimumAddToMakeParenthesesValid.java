/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package stack.parentheses;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    private int minAddToMakeValid_Using_Stack(String s) {
        final Stack<Character> stack = new Stack<>();
        int unbalancedClosed = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    ++unbalancedClosed;
                }
            }
        }
        return stack.size() + unbalancedClosed;
    }

    private int minAddToMakeValid(String s) {
        int unbalancedOpen = 0;
        int unbalancedClosed = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++unbalancedOpen;
            } else if (c == ')') {
                if (unbalancedOpen > 0) {
                    --unbalancedOpen;
                } else {
                    ++unbalancedClosed;
                }
            }
        }
        return unbalancedOpen + unbalancedClosed;
    }

    public static void main(String[] args) {
        String s = "(((";
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s));
    }
}
