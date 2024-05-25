/**
 * author: akhilpathivada
 * time: 25/05/24 08:44
 *
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/
 *
 */
package monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicateLetters {

    private String smallestSubsequence(String s) {
        final int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        final boolean[] seen = new boolean[26]; // to track already included elements
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (seen[index]) {
                freq[index]--;
                continue;
            }
            while (!stack.isEmpty() && s.charAt(i) <= stack.peek() && freq[stack.peek() - 'a'] > 1) {
                seen[stack.peek() - 'a'] = false;
                freq[stack.pop() - 'a']--;
            }
            seen[index] = true;
            stack.push(s.charAt(i));
        }
        final StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(new RemoveDuplicateLetters().smallestSubsequence(s));
    }
}
