/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */

package slidingwindow;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    private int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int[] freq = new int[128];
        // store frequencies of all chars
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (freq[s.charAt(i) - 'a'] >= k) {
                continue;
            }
            // window is broken here and new window should start from here
            int j = i + 1;
            while (j < s.length() && freq[s.charAt(j) - 'a'] < k) {
                ++j;
            }
            return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(j), k));
        }
        return s.length();
    }

    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring(s, k));
    }
}
