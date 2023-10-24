/**
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * Time Complexity: O(M * N * 4^L) where L is length of the word
 * Space Complexity: O(M * N)
 * */
package advanced.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    private static class TrieNode {
        private final TrieNode[] trie;
        private String wordEndingHere;
        private boolean isEndOfWord;

        private TrieNode() {
            this.trie = new TrieNode[26];;
            this.wordEndingHere = "";
            this.isEndOfWord = false;
        }

        public void insert(TrieNode root, String word) {
            for (char ch : word.toCharArray()) {
                if (root.trie[ch - 'a'] == null) {
                    root.trie[ch - 'a'] = new TrieNode();
                }
                root = root.trie[ch - 'a'];
            }
            root.isEndOfWord = true;
            root.wordEndingHere = word;
        }
    }

    // iterates over all the cells adjacent to a given cell
    // searches if the word is found
    private void searchWord(char[][] board, TrieNode root, List<String> result, int i, int j, int m, int n) {
        // base case : see i, j shouldn't exceed the boundaries
        if (root == null || i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '$') {
            return;
        }
        char ch = board[i][j];
        if (root.trie[ch - 'a'] == null) {
            return;
        }
        // mark the current cell as visited
        board[i][j] = '$';
        // check in all the adjacent directions
        searchWord(board, root.trie[ch - 'a'], result,  i + 1, j, m, n);
        searchWord(board, root.trie[ch - 'a'], result,  i - 1, j, m, n);
        searchWord(board, root.trie[ch - 'a'], result,  i, j - 1, m, n);
        searchWord(board, root.trie[ch - 'a'], result,  i, j + 1, m, n);
        // mark it as unvisited, since because the word is not found with this cell
        board[i][j] = ch;
        // the entire word id found
        if (root.trie[ch - 'a'].isEndOfWord) {
            String s = root.trie[ch - 'a'].wordEndingHere;
            if (!result.contains(s)) {
                result.add(root.trie[ch - 'a'].wordEndingHere);
            }
        }
    }

    private List<String> findWords(char[][] board, String[] words) {
        TrieNode prefixTree = new TrieNode();
        int m = board.length;
        int n = board[0].length;
        // construct a trie with the given words
        for (String word : words) {
            prefixTree.insert(prefixTree, word);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                char ch = board[i][j];
                // always assume the word starts with this cell
                if (prefixTree.trie[ch - 'a'] != null) {
                    searchWord(board, prefixTree, result, i, j, m, n);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        String[] words = { "oath", "pea", "eat", "rain" };
        System.out.println(new WordSearchII().findWords(board, words));
    }
}
