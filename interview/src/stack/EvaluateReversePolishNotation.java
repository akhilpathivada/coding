/**
 * @author akhilpathivada
 * <p>
 * date : 21/03/24
 * time: 09:38
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    private int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                stack.push(-(stack.pop() - stack.pop()));
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int divisor = stack.pop();
                int dividend = stack.pop();
                stack.push(dividend / divisor);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }
}
