/**
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */

package strings;

public class ValidPalindromeI {

    private boolean isPalindrome(String s) {
        // base case
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            // if start char is not letter or digit : we don't compare
            if (!Character.isLetterOrDigit(startChar)) {
                ++start;
            } else if (!Character.isLetterOrDigit(endChar)) { // if end char is not letter or digit : we don't compare
                --end;
            } else {
                if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) { // characters not matching
                    return false;
                }
                ++start;
                --end;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindromeI().isPalindrome(s));
    }
}
