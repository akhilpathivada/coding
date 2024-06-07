/**
 * author: akhilpathivada
 * time: 07/06/24 08:45
 *
 * https://leetcode.com/problems/short-encoding-of-words/description/
 *
 */
package trie;

import java.util.Arrays;

public class ShortEncodingOfWords {

    private final class TrieNode {

        private final TrieNode[] children;

        private TrieNode() {
            this.children = new TrieNode[26];
        }

        private boolean isAnyNewNodeCreated(String word) {
            TrieNode root = this;
            boolean isAnyNewNodeCreated = false;
            for (int i = word.length() - 1; i >= 0; --i) {
                char c = word.charAt(i);
                if (root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new TrieNode();
                    isAnyNewNodeCreated = true;
                }
                root = root.children[c - 'a'];
            }
            return isAnyNewNodeCreated;
        }
    }

    private int minimumLengthEncoding(String[] words) {
        final TrieNode suffixTree = new TrieNode();
        Arrays.sort(words, (a, b) -> {
            return b.length() - a.length();
        });
        int encodingLength = 0;
        for (String word : words) {
            encodingLength += suffixTree.isAnyNewNodeCreated(word) ? word.length() + 1 : 0;
        }
        return encodingLength;
    }

    public static void main(String[] args) {
//        String[] words = {"time", "me", "bell"};
        String[] words = {"time","atime","btime"};
        System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(words));
    }
}
