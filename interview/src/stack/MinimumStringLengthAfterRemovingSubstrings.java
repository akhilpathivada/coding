/**
 * author: akhilpathivada
 * time: 07/10/24 08:27
 *
 * https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
 */
package stack;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {

    private int minLength(String s) {
        final Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && ((c == 'B' && stack.peek() == 'A') || (c == 'D' && stack.peek() == 'C'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(new MinimumStringLengthAfterRemovingSubstrings().minLength(s));
    }
}
