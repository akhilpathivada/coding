/**
 * https://leetcode.com/problems/letter-case-permutation/description/
 *
 * Time Complexity: O(2^n))
 * Space Complexity: O(2^k)
 * */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    private void backtrack(List<String> result, String currentString, String s, int i) {

        if (currentString.length() == s.length()) {
            result.add(currentString);
            return;
        }
        if (Character.isDigit(s.charAt(i))) {
            backtrack(result, currentString + s.charAt(i), s, i + 1);
        } else {
            backtrack(result, currentString + Character.toLowerCase(s.charAt(i)), s, i + 1);
            backtrack(result, currentString + Character.toUpperCase(s.charAt(i)), s, i + 1);
        }
    }

    private List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", s, 0);
        return result;
    }

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(new LetterCasePermutation().letterCasePermutation(s));
    }
}
