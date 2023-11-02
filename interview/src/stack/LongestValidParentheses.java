/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package stack;

import java.util.Stack;

public class LongestValidParentheses {

    private int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        // iterate over string
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }
}
