/**
 * https://leetcode.com/problems/break-a-palindrome/
 *
 * Time Complexity : O(N)
 * */
package strings;

public class BreakPalindromeUsingOneChar {

        private String breakPalindrome(String palindrome) {
                final char[] p = palindrome.toCharArray();
                final int n = palindrome.length();
                if (n == 1) { // if given string is 'a' or like that
                        return "IMPOSSIBLE";
                }
                for (int i = 0; i < n; ++i) {
                        int j = n - i - 1; // get corresponding palindromic char of p[i]
                        if (i == j) { // when n is odd, we cant do this operation
                                continue;
                        }
                        if (p[i] != 'a') {
                                p[i] = 'a';
                                return String.valueOf(p);
                        }
                }
                p[n - 1] = 'b'; // if given string is all a's
                return String.valueOf(p);
        }

        public static void main(String[] args) {
                String palindrome = "abccba";
                System.out.println(new BreakPalindromeUsingOneChar().breakPalindrome(palindrome));
        }
}
