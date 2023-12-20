/**
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * Time Complexity: O(2 * N)
 * Space Complexity: O(1)
 * */
package patternmatch;

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        String copyOfOriginalString = s;
        // adding '#' in the middle to deal the case, where
        // 's' itself is a palindrome
        s += "#" + new StringBuilder(s).reverse();
        int n = s.length();
        // logic of computing the lps[] from KMP Algorithm
        int[] lps = new int[n];
        int len = 0;
        lps[0] = 0;
        for (int i = 1; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = len + 1;
                ++len;
                ++i;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    ++i;
                }
            }
        }
        return new StringBuilder(s.substring(lps[n - 1], copyOfOriginalString.length())).reverse() + copyOfOriginalString;
    }

    public static void main(String[] args) { // aaaaa
        String s = "aaaaa";
        System.out.println(new ShortestPalindrome().shortestPalindrome(s));
    }
}
