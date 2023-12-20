/**
 * https://leetcode.com/problems/longest-happy-prefix/description/
 * https://www.codingninjas.com/studio/problems/longest-prefix-which-is-suffix_3146849
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package patternmatch;

public class LongestHappyPrefix {

    public String longestPrefix(String s) {
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
        return s.substring(0, lps[n - 1]);
    }

    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(new LongestHappyPrefix().longestPrefix(s));
    }
}
