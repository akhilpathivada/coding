package slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 26/04/24
 * Time 17:29
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        final int[] count = new int[26];
        final List<Integer> result = new ArrayList<>();
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            count[c - 'a']--;
            while (count[c - 'a'] < 0) {
                count[s.charAt(left++) - 'a']++;
            }
            if (right - left + 1 == p.length()) {
                result.add(left);
                while (count[s.charAt(left)] < 0) {
                    count[s.charAt(left++) - 'a']++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(new FindAllAnagramsInAString().findAnagrams(s, p));
    }
}
