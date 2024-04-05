/**
 * Date 05/04/2024
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/longest-string-chain/description/
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(N)
 * */
package dp.lis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    private int longestStrChain(String[] words) {
        // sort based on the word size
        Arrays.sort(words, (word1, word2) -> word1.length() - word2.length());
        // store (word, no. of predecessors)
        Map<String, Integer> dp = new HashMap<>();
        int maxChainLength = 0;
        for (String word : words) {
            int numberOfPredecessors = 0;
            for (int i = 0; i < word.length(); ++i) {
                String predecessor = new StringBuilder(word).deleteCharAt(i).toString();
                numberOfPredecessors = Math.max(numberOfPredecessors, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, numberOfPredecessors);
            maxChainLength = Math.max(maxChainLength, dp.get(word));
        }
        return maxChainLength;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(new LongestStringChain().longestStrChain(words));
    }
}
