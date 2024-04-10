/**
 * Date 09/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/implement-magic-dictionary/
 */
package trie;

public class MagicDictionary {

    private final TrieNode prefixTree;

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

        public boolean search(String dict) {
            TrieNode root = this;
            for (char c : dict.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    return false;
                }
                root = root.children[c - 'a'];
            }
            return root.isEndOfWord;
        }
    }

    public MagicDictionary() {
        prefixTree = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String dict : dictionary) {
            prefixTree.insert(dict);
        }
    }

    public boolean search(String searchWord) {
        StringBuilder sb = new StringBuilder(searchWord);
        for (int i = 0; i < sb.length(); ++i) {
            char originalChar = sb.charAt(i);
            for (char j = 'a'; j <= 'z'; ++j) {
                if (j == originalChar) {
                    continue;
                }
                sb.setCharAt(i, j);
                if (prefixTree.search(sb.toString())) {
                    return true;
                }
            }
            sb.setCharAt(i, originalChar);
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello")); // return False
        System.out.println(magicDictionary.search("hhllo")); // We can change the second 'h' to 'e' to match "hello" so we return True
        System.out.println(magicDictionary.search("hell")); // return False
        System.out.println(magicDictionary.search("leetcoded")); // return False
    }
}
