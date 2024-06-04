/**
 * https://leetcode.com/problems/palindrome-pairs/
 *
 * */
package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PalindromePairs {

    private final class TrieNode {

        private final TrieNode[] trie;

        private List<Integer> wordsEndingHere;

        private List<Integer> wordsSharingThisNode;

        public TrieNode() {
            this.trie = new TrieNode[26];
            this.wordsEndingHere = new ArrayList<>(); // store indices
            this.wordsSharingThisNode = new ArrayList<>(); // store indices
        }

        public void insert(String word, int index) {
            TrieNode root = this;
            root.wordsSharingThisNode.add(index);
            for (char ch : word.toCharArray()) {
                if (root.trie[ch - 'a'] == null) {
                    root.trie[ch - 'a'] = new TrieNode();
                }
                root = root.trie[ch - 'a'];
                root.wordsSharingThisNode.add(index);
            }
            root.wordsEndingHere.add(index);
        }
    }

    private TrieNode suffixTree;

    private void addPalindromePairs(String[] words, String sourceWord,
                                     int indexOfSourceWord, List<List<Integer>> palindromePairs) {
        TrieNode root = suffixTree;
        System.out.println("source word = " + sourceWord);
        for (int i = 0; i < sourceWord.length(); ++i) {
            char ch = sourceWord.charAt(i);
            for (int index : root.wordsEndingHere) {
                if (index == indexOfSourceWord) {
                    continue;
                }
                String remaining = words[index].isEmpty() ? sourceWord : sourceWord.substring(0, sourceWord.length() - words[index].length());
                System.out.println("remaing = " + remaining);
                if (isPalindrome(remaining)) {
                    System.out.println("adding 1 = " + sourceWord + ", " + words[index]);
                    palindromePairs.add(Arrays.asList(indexOfSourceWord, index));
                }
            }
            root = root.trie[ch - 'a'];
            if (root == null) {
                return;
            }
        }

        for (int index : root.wordsEndingHere) {
            if (index == indexOfSourceWord) {
                continue;
            }
            System.out.println("adding 2 = " + sourceWord + ", " + words[index]);
            palindromePairs.add(Arrays.asList(indexOfSourceWord, index));
        }
        System.out.println("root.wordsSharingThisNode  " + root.wordsSharingThisNode);
        for (int index : root.wordsSharingThisNode) {
            if (index == indexOfSourceWord) {
                continue;
            }
            String remaining = words[index].isEmpty() ? sourceWord : words[index].substring(0, words[index].length() - sourceWord.length());
            System.out.println("remaining  = " + remaining);
            if (isPalindrome(remaining)) {
                System.out.println("adding 3 = " + sourceWord + ", " + words[index]);
                palindromePairs.add(Arrays.asList(indexOfSourceWord, index));
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private List<List<Integer>> palindromePairs(String[] words) {
        suffixTree = new TrieNode();
        // insert the words into suffix tree in reverse order
        for (int i = 0; i < words.length; ++i) {
            suffixTree.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            addPalindromePairs(words, words[i], i, result);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
//        String[] words = {"a","abc","aba",""}; // [[0,3],[3,0],[2,3],[3,2]]
//        String[] words = {"a",""};
//        String s = "";
//        System.out.println("b" + s + "a");
        System.out.println(new PalindromePairs().palindromePairs(words));
    }
}
