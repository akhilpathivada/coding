/**
 * author: akhilpathivada
 * time: 05/06/24 17:52
 *
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 */
package hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    private int longestPalindrome(String s) {
        final Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? s.length() : s.length() - set.size() + 1;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }
}
