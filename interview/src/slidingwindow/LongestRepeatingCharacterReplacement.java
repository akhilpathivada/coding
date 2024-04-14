/**
 * Date 14/04/24
 * Time 06:03
 *
 * @author akhilpathivada
 *
 *  https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package slidingwindow;

public class LongestRepeatingCharacterReplacement {

    private int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int count = 0;
        int[] freq = new int[26];
        for (int right = 0; right < s.length(); ++right) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            // update left, maxFreq when window is invalid
            while (right - left + 1 - maxFreq > k) {
                freq[s.charAt(left++) - 'A']--;
            }
            count = Math.max(count, right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));
    }
}
