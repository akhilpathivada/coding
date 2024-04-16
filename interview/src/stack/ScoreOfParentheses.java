package stack;

import java.util.Stack;

/**
 * Date 16/04/24
 * Time 08:00
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/score-of-parentheses/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ScoreOfParentheses {

    private int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(new ScoreOfParentheses().scoreOfParentheses(s));
    }
}
