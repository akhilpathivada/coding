/**
 * author: akhilpathivada
 * time: 29/09/24 10:08
 *
 * https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description/
 *
 */
package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfPrefixScoresOfStrings {

    private final class TrieNode {

        private final TrieNode[] children;

        private int countOfWordsWithPrefix; // tracks count of words having till this node as prefix

        private TrieNode() {
            this.children = new TrieNode[26];
            this.countOfWordsWithPrefix = 0;
        }

        private void insert(String word) {
            TrieNode root = this;
            for (char letter : word.toCharArray()) {
                int index = letter - 'a';
                if (root.children[index] == null) {
                    root.children[index] = new TrieNode();
                }
                root = root.children[index];
                root.countOfWordsWithPrefix++;
            }
        }
    }

    private int[] sumPrefixScores(String[] words) {
        final TrieNode root = new TrieNode(); // initialize the trie
        final List<Integer> result = new ArrayList<>();
        Arrays.stream(words).forEach(root::insert);
        for (String word : words) {
            int count = 0;
            TrieNode current = root;
            for (char letter : word.toCharArray()) {
                int index = letter - 'a';
                count += current.children[index].countOfWordsWithPrefix;
                current = current.children[index];
            }
            result.add(count);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String[] words = {"abc", "ab", "bc", "b"};
        System.out.println(Arrays.toString(new SumOfPrefixScoresOfStrings().sumPrefixScores(words)));
    }
}
