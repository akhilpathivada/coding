/**
 * https://leetcode.com/problems/prefix-and-suffix-search/description/
 *
 * Time Complexity: O(N * L) + Q(L + N)  where N -> no. of words, L -> length of the word, Q -> no. of queries
 * Space Complexity: O(N * L)
 * */
package advanced.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrefixAndSuffixSearch {
    private static class TrieNode {
        private final TrieNode[] trie;
        private final List<Integer> index;

        private TrieNode() {
            this.trie = new TrieNode[26];
            this.index = new ArrayList<>();
        }

        // insert the word into trie
        private void insert(String word, int i) {
            TrieNode root = this;
            for (char ch : word.toCharArray()) {
                if (root.trie[ch - 'a'] == null) {
                    root.trie[ch - 'a'] = new TrieNode();
                }
                root = root.trie[ch - 'a'];
                root.index.add(i);
            }
        }

        // search the word into trie
        private List<Integer> startsWith(String word) {
            TrieNode root = this;
            for (char ch : word.toCharArray()) {
                if (root.trie[ch - 'a'] == null) {
                    return new ArrayList<>();
                }
                root = root.trie[ch - 'a'];
            }
            return root.index;
        }
    }

    private static class WordFilter {

        TrieNode prefixTree, suffixTree;
        public WordFilter(String[] words) {
            prefixTree = new TrieNode();
            suffixTree = new TrieNode();
            // construct both prefix and suffix trees
            for (int i = 0; i < words.length; ++i) {
                prefixTree.insert(words[i], i);
                suffixTree.insert(new StringBuilder(words[i]).reverse().toString(), i);
            }
        }

        public int f(String pref, String suff) {
            List<Integer> prefixMatchList = prefixTree.startsWith(pref);
            List<Integer> suffixMatchList = suffixTree.startsWith(new StringBuilder(suff).reverse().toString());
            // find the common most index in both matches
            int i = prefixMatchList.size() - 1, j = suffixMatchList.size() - 1;
            while (i >= 0 && j >= 0) {
                if (Objects.equals(prefixMatchList.get(i), suffixMatchList.get(j))) {
                    return prefixMatchList.get(i);
                } else if (prefixMatchList.get(i) > suffixMatchList.get(j)) {
                    --i;
                } else {
                    --j;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String[] words = {"apple", "applet", "ape", "applte", "cat"};
        System.out.println(new PrefixAndSuffixSearch.WordFilter(words).f("a", "e"));
    }
}
