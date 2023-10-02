/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersII {

        private static int lengthOfLongestSubstring(String s) {

                Set<Character> set = new HashSet<>();
                int i = 0, indexOfSubstringStart = 0, maxLength = 0;
                while (i < s.length()) {
                        // first time visiting a character : so include it in max length
                        if (!set.contains(s.charAt(i))) {
                                set.add(s.charAt(i));
                                maxLength = Math.max(set.size(), maxLength);
                                ++i;
                        } else { // already visited the character : so slide the window
                                set.remove(s.charAt(indexOfSubstringStart));
                                ++indexOfSubstringStart;
                        }
                }
                return maxLength;
        }

        public static void main(String[] args) {

                String str = "abcabcbb";
                System.out.printf("Longest Substring without repeating characters = %d ",
                        lengthOfLongestSubstring(str));
        }
}
