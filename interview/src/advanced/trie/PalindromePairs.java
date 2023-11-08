/**
 * https://leetcode.com/problems/palindrome-pairs/
 *
 * */
package advanced.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {

    class TrieNode {
        TrieNode[] trie;

        List<Integer> indexOfStringsEndingHere;

        List<Integer> indexOfStringsHavingThisChar;

        public TrieNode() {
            trie = new TrieNode[256];
            // initialize all 256 indexes as null
            Arrays.fill(trie, null);
            indexOfStringsEndingHere = new ArrayList<>();
            indexOfStringsHavingThisChar = new ArrayList<>();
        }

        public void insertIntoSuffixTree(String word, int index) {
            TrieNode root = this;
            root.indexOfStringsHavingThisChar.add(index);
            for (char ch : word.toCharArray()) {
                if (root.trie[ch] == null) {
                    root.trie[ch] = new TrieNode();
                }
                root = root.trie[ch];
                root.indexOfStringsHavingThisChar.add(index);
            }
            System.out.println("came here " + word);
            root.indexOfStringsEndingHere.add(index);
            System.out.println(root.indexOfStringsEndingHere);
        }
    }

    private TrieNode suffixTree = new TrieNode();

    private List<List<Integer>> findPalindromePairs(String[] words, String word, int indexOfString) {
        TrieNode root = suffixTree;
        List<List<Integer>> palindromicPairs = new ArrayList<>();
        if (!root.indexOfStringsEndingHere.isEmpty()) {
            for (int indexOfStringEndingHere : root.indexOfStringsEndingHere) {
                if (indexOfStringEndingHere != indexOfString) {
                    palindromicPairs.add(new ArrayList<>(Arrays.asList(indexOfString, indexOfStringEndingHere)));
                }
            }
        }
        for (char ch : word.toCharArray()) {
            if (root.trie[ch] == null) {
                return null;
            }
            root = root.trie[ch];
        }
        for (int indexOfStringEndingHere : root.indexOfStringsEndingHere) {
            if (indexOfStringEndingHere != indexOfString) {
                palindromicPairs.add(new ArrayList<>(Arrays.asList(indexOfString, indexOfStringEndingHere)));
            }
        }
        for (int indexOfStringHavingThisChar : root.indexOfStringsHavingThisChar) {
            if (indexOfStringHavingThisChar != indexOfString && isRestOfStringPalindrome(
                    word.charAt(word.length() - 1) + words[indexOfStringHavingThisChar], word.length() - 1)) {
                palindromicPairs.add(new ArrayList<>(Arrays.asList(indexOfString, indexOfStringHavingThisChar)));
            }
        }
        return palindromicPairs;
    }

    private String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private boolean isRestOfStringPalindrome(String s, int endIndex) {
        int left = 0;
        int right = endIndex;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private List<List<Integer>> palindromePairs(String[] words) {
        // insert the words into suffix tree in reverse order
        for (int i = 0; i < words.length; ++i) {
            suffixTree.insertIntoSuffixTree(reverseString(words[i]), i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            List<List<Integer>> palindromicPairs = findPalindromePairs(words, words[i], i);
            if (palindromicPairs != null) {
                for (List<Integer> pair : palindromicPairs) {
                    result.add(new ArrayList<>(pair));
                }
            }
        }
        System.out.println("ak = " + suffixTree.indexOfStringsHavingThisChar);
        return result;
    }

    public static void main(String[] args) {
//        String[] words = {"abcd","dcba","lls","s","sssll"};
        String[] words = {"a","abc","aba",""};
//        String s = "";
//        System.out.println("b" + s + "a");
        System.out.println(new PalindromePairs().palindromePairs(words));
    }
}
