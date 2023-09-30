/**
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */

package strings;

public class ValidPalindromeII {

    // check is s[i...j] is palindrome.
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    private boolean validPalindrome(String s) {
        // base case
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
            ++start;
            --end;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(new ValidPalindromeII().validPalindrome(s));
    }
}
