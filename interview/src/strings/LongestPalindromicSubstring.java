/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(1)
 * */
package strings;

public class LongestPalindromicSubstring {

    private static String longestPalindrome(String s) {
        // base case
        if (s == null || s.isEmpty()) {
            return "";
        }
        // holds the final output palindromic substring boundaries
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); ++i) {
            // for odd length : passing (i, i) because the middle element
            // doesn't have any matching char
            int length1 = expandFromTheMiddle(s, i, i);
            // for even : every element will have it's matching char
            int length2 = expandFromTheMiddle(s, i, i + 1);
            // we always want the max. palindromic substring length
            int maxLength = Math.max(length1, length2);

            if (maxLength > end - start) {
                start = i - ((maxLength - 1) / 2);
                end = i + (maxLength / 2);
            }
        }
        // output substring
        return s.substring(start, end + 1);
    }

    // The logic behind this is for any given index, it will be expanded both left and right
    // sides till it's a palindromic match and return it's length
    private static int expandFromTheMiddle(String s, int left, int right) {
        // base case
        if (s == null || left > right) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(longestPalindrome(s));
    }
}
