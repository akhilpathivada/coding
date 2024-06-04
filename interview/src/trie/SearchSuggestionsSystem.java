/**
 * author: akhilpathivada
 * time: 03/06/24 08:55
 *
 * https://leetcode.com/problems/search-suggestions-system/description/
 *
 */
package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

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

        private TrieNode getLastNode(String word) {
            TrieNode root = this;
            for (char c : word.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    return null;
                }
                root = root.children[c - 'a'];
            }
            return root;
        }
    }

    private TrieNode trie;

    private List<String> dfs(TrieNode root, String word, List<String> suggestions) {
        if (root == null || suggestions.size() == 3) {
            return suggestions;
        }
        if (root.isEndOfWord) {
            suggestions.add(word);
        }
        for (int i = 0; i < 26; ++i) {
            dfs(root.children[i], word + Character.toString(i + 'a'), suggestions);
        }
        return suggestions;
    }

    private List<List<String>> suggestedProducts(String[] products, String searchWord) {
        trie = new TrieNode();
        Arrays.sort(products);
        for (String product : products) {
            trie.insert(product);
        }
        final List<List<String>> result = new ArrayList<>();
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            // last node of the prefix is our starting point to dfs
            result.add(dfs(trie.getLastNode(prefix), prefix, new ArrayList<>()));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(new SearchSuggestionsSystem().suggestedProducts(products, searchWord));
    }
}
