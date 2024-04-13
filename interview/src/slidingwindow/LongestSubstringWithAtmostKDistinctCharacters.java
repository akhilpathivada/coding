/**
 * Date 12/04/24
 *
 * @author akhilpathivada
 *
 * https://www.naukri.com/code360/problems/longest-substring-with-at-most-k-distinct-characters_2221410
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(k)
 */
package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinctCharacters {
    private int kDistinctChars(int k, String s) {
        // Write your code here
        int maxLength = 0;
        int startIndexOfSubstring = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
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
        int k = 2;
        String s = "abbbbbbc";
        System.out.println(new LongestSubstringWithAtmostKDistinctCharacters().kDistinctChars(k, s));
    }
}
