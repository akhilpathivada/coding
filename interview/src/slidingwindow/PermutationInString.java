package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Date 26/04/24
 * Time 16:23
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 */
public class PermutationInString {

    private boolean checkInclusion(String s1, String s2) {
        final int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s2.length(); ++right) {
            char c = s2.charAt(right);
            count[c - 'a']--;
            while (count[c - 'a'] < 0) {
                count[s2.charAt(left++) - 'a']++;
            }
            if (right - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(new PermutationInString().checkInclusion(s1, s2));
    }
}
