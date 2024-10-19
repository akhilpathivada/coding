/**
 * author: akhilpathivada
 * time: 19/10/24 06:38
 *
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 *
 */
package stack.parentheses;

import java.util.Stack;

public class ValidParenthesisString {

    private boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(' || stack.peek() != '*') {
                    System.out.println("came here");
                    return false;
                }
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else if (stack.peek() == '(' || stack.peek() == '*') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty() || (stack.size() == 1 && stack.peek() == '*');
    }

    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(new ValidParenthesisString().checkValidString(s));
    }
}
