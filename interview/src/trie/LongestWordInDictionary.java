/**
 * author: akhilpathivada
 * time: 03/06/24 07:32
 *
 * https://leetcode.com/problems/longest-word-in-dictionary/description/
 *
 */
package trie;

import trie.base.TrieNode;

import java.util.Arrays;

public class LongestWordInDictionary {

    private final class TrieNode {

        private final TrieNode[] children;

        private boolean isEndOfWord;

        private TrieNode() {
            this.children = new TrieNode[26];
        }

        private void insert(String word) {
            TrieNode root = this;
            for (char c : word.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new TrieNode();
                }
                root = root.children[c - 'a'];
            }
            root.isEndOfWord = true;
        }

        private boolean contains(String word) {
            TrieNode root = this;
            for (char c : word.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    return false;
                }
                root = root.children[c - 'a'];
            }
            return root.isEndOfWord;
        }
    }

    private String longestWord(String[] words) {
        TrieNode trie = new TrieNode();
        Arrays.sort(words);
        String result = "";
        for (String word : words) {
            String prefix = word.substring(0, word.length() - 1);
            if (word.length() == 1 || trie.contains(prefix)) {
                if (word.length() > result.length()) {
                    result = word;
                }
                trie.insert(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(new LongestWordInDictionary().longestWord(words));
    }
}
