/**
 * Date 13/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/count-vowel-substrings-of-a-string/description/
 */
package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountVowelSubstringsOfAString {

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private int countVowelSubstringsUtil(String word, int k) {
        int left = 0;
        int count = 0;
        Map<Character, Integer> vowelMap = new HashMap<>();
        for (int right = 0; right < word.length(); ++right) {
            char c = word.charAt(right);
            if (!isVowel(c)) { // new window starts
                vowelMap.clear();
                left = right + 1;
                continue;
            }
            vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            while (vowelMap.size() > k) {
                c = word.charAt(left);
                vowelMap.put(c, vowelMap.get(c) - 1);
                if (vowelMap.get(c) == 0) {
                    vowelMap.remove(c);
                }
                ++left;
            }
            count += right - left + 1;
        }
        return count;
    }

    private int countVowelSubstrings(String word) {
        return countVowelSubstringsUtil(word, 5) - countVowelSubstringsUtil(word, 4);
    }

    public static void main(String[] args) {
        String word = "cuaieuouac";
        System.out.println(new CountVowelSubstringsOfAString().countVowelSubstrings(word));
    }
}
