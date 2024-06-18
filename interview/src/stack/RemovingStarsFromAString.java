/**
 * author: akhilpathivada
 * time: 18/06/24 16:42
 *
 * https://leetcode.com/problems/removing-stars-from-a-string/description/
 *
 */
package stack;

import java.util.Stack;

public class RemovingStarsFromAString {

    private String removeStars(String s) {
        final Stack<Character> stack = new Stack<>();
        final StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(new RemovingStarsFromAString().removeStars(s));
    }
}
