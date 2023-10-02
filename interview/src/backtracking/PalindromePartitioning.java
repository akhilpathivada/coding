/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * Time Complexity: O()
 * Space Complexity: O()
 * */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private boolean isPalindrome(String s, int left, int right) {
        if (left == right) {
            return true;
        }
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    private void backtrack(String s, int left, List<List<String>> output, List<String> currentPalindromeList) {
        // base case
        if (currentPalindromeList.size() > 0 && left >= s.length()) {
            output.add(new ArrayList<>(currentPalindromeList));
        }
        for (int i = left; i < s.length(); ++i) {
            if (isPalindrome(s, left, i)) {
                if (left == i) {
                    currentPalindromeList.add(Character.toString(s.charAt(i)));
                } else {
                    currentPalindromeList.add(s.substring(left, i + 1));
                }

                backtrack(s, i + 1, output, currentPalindromeList);
                currentPalindromeList.remove(currentPalindromeList.size() - 1);
            }
        }
    }

    private List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        List<String> currentPalindrome = new ArrayList<>();
        // start palindrome partioning with index '0'
        backtrack(s, 0, output, currentPalindrome);
        return output;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioning().partition(s));
    }
}
