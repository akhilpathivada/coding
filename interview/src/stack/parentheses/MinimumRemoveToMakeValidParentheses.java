/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package stack.parentheses;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

        private String minRemove(String s) {
                final StringBuilder sb = new StringBuilder(s);
                final Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < sb.length(); ++i) {
                        if (sb.charAt(i) == '(') { // push the index of '('
                                stack.push(i);
                        } else if (sb.charAt(i) == ')') {
                                if (!stack.isEmpty()) { // balanced
                                        stack.pop();
                                } else { // replace ')' with '*'
                                        sb.setCharAt(i, '*');
                                }
                        }
                }
                while (!stack.isEmpty()) { // replace ')' with '*'
                        sb.setCharAt(stack.pop(), '*');
                }
                return sb.toString().replaceAll("\\*", ""); // replace '*' with ''
        }

        public static void main(String[] args) {
                String s = "lee(t(c)o)de)";
                System.out.println("Valid string after removal = "
                        + new MinimumRemoveToMakeValidParentheses().minRemove(s));
        }
}
