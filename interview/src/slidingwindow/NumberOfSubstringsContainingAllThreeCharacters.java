/**
 * Date 13/04/24
 * Time 08:58
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 *
 */
package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsContainingAllThreeCharacters {

    private int numberOfSubstringsUtil(String s, int k) {
        int left = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                ++left;
            }
            count += right - left + 1;
        }
        return count;
    }

    private int numberOfSubstrings(String s) {
        return numberOfSubstringsUtil(s, 3) - numberOfSubstringsUtil(s, 2);
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(new NumberOfSubstringsContainingAllThreeCharacters().numberOfSubstrings(s));
    }
}
