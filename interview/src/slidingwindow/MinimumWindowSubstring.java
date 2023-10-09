/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */

package slidingwindow;

public class MinimumWindowSubstring {

    private String minWindow(String s, String t) {
        // base case
        if (t.length() > s.length()) {
            return "";
        }
        // store the frequencies all chars of 't'
        int[] frequency = new int[128];
        for (char ch : t.toCharArray()) {
            frequency[ch]++;
        }
        // captures start of the window
        int start = 0;
        int startIndexOfResultWindow = 0;
        int countOfCharactersToFind = t.length();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            // we found the char of 't' : which exists in 's'
            if (frequency[ch] > 0) {
                --countOfCharactersToFind;
            }
            frequency[ch]--;

            // we found the window which contains all chars of 't'
            while (countOfCharactersToFind == 0) {
                // assume window ends here
                int end = i;
                if (minLength > end - start) {
                    minLength = end - start;
                    startIndexOfResultWindow = start;
                }
                frequency[s.charAt(start)]++;
                if (frequency[s.charAt(start)] > 0) {
                    ++countOfCharactersToFind;
                }
                ++start;
            }
        }

        return minLength == Integer.MAX_VALUE ?
                "" :
                s.substring(startIndexOfResultWindow, startIndexOfResultWindow + minLength + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }
}
