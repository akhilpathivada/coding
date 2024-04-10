/**
 * Date 09/04/24
 *
 * @author akhilpathivada
 * 
 * https://leetcode.com/problems/stream-of-characters/description/
 * 
 */
package trie;

public class StreamChecker {

    private final TrieNode suffixTree;

    private final StringBuilder stream;

    private static final class TrieNode {

        private final TrieNode[] children;

        private boolean isEndOfWord;

        private TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }

        public void insert(String dict) {
            TrieNode root = this;
            for (char c : dict.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new TrieNode();
                }
                root = root.children[c - 'a'];
            }
            root.isEndOfWord = true;
        }

    }

    public StreamChecker(String[] words) {
        suffixTree = new TrieNode();
        stream = new StringBuilder();
        for (String word : words) {
            suffixTree.insert(new StringBuilder(word).reverse().toString());
        }
    }

    public boolean query(char letter) {
        stream.append(letter);
        TrieNode current = suffixTree;
        for (int i = stream.length() - 1; i >= 0 && current != null; --i) {
            TrieNode node = current.children[stream.charAt(i) - 'a'];
            if (node != null && node.isEndOfWord) {
                return true;
            }
            current = node;
        }
        return false;
    }

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        System.out.println(streamChecker.query('a')); // return False
        System.out.println(streamChecker.query('b')); // return False
        System.out.println(streamChecker.query('c')); // return False
        System.out.println(streamChecker.query('d')); // return True, because 'cd' is in the wordlist
        System.out.println(streamChecker.query('e')); // return False
        System.out.println(streamChecker.query('f')); // return True, because 'f' is in the wordlist
        System.out.println(streamChecker.query('g')); // return False
        System.out.println(streamChecker.query('h')); // return False
        System.out.println(streamChecker.query('i')); // return False
        System.out.println(streamChecker.query('j')); // return False
        System.out.println(streamChecker.query('k')); // return False
        System.out.println(streamChecker.query('l')); // return True, because 'kl' is in the wordlist
    }
}
