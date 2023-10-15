/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(1)
 * */
package strings;

public class PalindromicSubstrings {

    int count = 0;
    private int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < s.length(); ++i) { // assume 'i' as the midpoint
            // odd length
            extendPalindrome(s, i, i);
            // even length
            extendPalindrome(s, i, i + 1);
        }
        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
            ++count;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new PalindromicSubstrings().countSubstrings(s));
    }
}
