/**
 * @author akhilpathivada
 * <p>
 * date : 02/04/24
 * time: 07:14
 *
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 *
 */
package trie;

public class WordDictionary {

    // implementing the trie data structure

    private final WordDictionary[] children;

    private boolean isEndOfWord;

    public WordDictionary() {
        children = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary current = this;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new WordDictionary();
            }
            current = current.children[c - 'a'];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        WordDictionary current = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                // search all the children of the node
                for (WordDictionary child : current.children) {
                    if (child != null && child.search(word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current != null && current.isEndOfWord;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
