/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * */
package backtracking;

import java.util.Arrays;
import java.util.List;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    private int max = 0;

    private boolean hasCommon(String s1, String s2) {
        int[] freq = new int[26];
        s1 += s2;
        for (char ch : s1.toCharArray()) {
            if (freq[ch - 'a'] == 1) {
                return true;
            }
            freq[ch - 'a']++;
        }
        return false;
    }

    private void backtrack(List<String> arr, String current, int index) {
        if (current.length() > max) {
            max = current.length();
        }
        for (int i = 0; i < arr.size(); ++i) {
            if (!hasCommon(current, arr.get(i))) {
                backtrack(arr, current + arr.get(i), i + 1);
            }
        }
    }

    private int maxLength(List<String> arr) {
        backtrack(arr, "", 0);
        return max;
    }

    public static void main(String[] args) {
        String[] arr = new String[] { "un", "iq", "ue" };
        System.out.println(new MaximumLengthOfConcatenatedStringWithUniqueCharacters().maxLength(Arrays.asList(arr)));
    }
}
