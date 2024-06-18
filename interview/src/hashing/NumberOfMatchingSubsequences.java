/**
 * author: akhilpathivada
 * time: 18/06/24 12:54
 *
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 *
 */
package hashing;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {

    private boolean isSubsequence(String a, String b, int m, int n) {
        int j = 0;
        for (int i = 0; i < m && j < n; ++i) {
            if (a.charAt(i) == b.charAt(j)) {
                ++j;
            }
        }
        return j == n;
    }

    private int numMatchingSubseq(String s, String[] words) {
        final Map<String, Integer> wordFrequencyMap = new HashMap<>();
        int matches = 0;
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            String word = entry.getKey();
            if (isSubsequence(s, word, s.length(), word.length())) {
                matches += entry.getValue();
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq(s, words));
    }
}
