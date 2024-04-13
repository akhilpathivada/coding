/**
 * Date 12/04/24
 *
 * @author akhilpathivada
 *
 * https://www.naukri.com/code360/problems/longest-substring-with-at-most-two-distinct-characters_3125863
 * https://leetcode.ca/all/159.html
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package slidingwindow;

import java.util.*;

public class LongestSubstringWithAtmostTwoDistinctCharacters {

    private int lengthOfLongestSubstring(String s) {
        // Write your code here.
        int maxLength = 0;
        int startIndexOfSubstring = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                char t = s.charAt(startIndexOfSubstring);
                map.put(t, map.get(t) - 1);
                if (map.get(t) == 0) {
                    map.remove(t);
                }
                ++startIndexOfSubstring;
            }
            maxLength = Math.max(maxLength, i - startIndexOfSubstring + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "fffatfattfafaaafftaf";
        System.out.println(new LongestSubstringWithAtmostTwoDistinctCharacters().lengthOfLongestSubstring(s));
    }
}
