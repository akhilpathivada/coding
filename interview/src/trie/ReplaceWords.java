package trie;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReplaceWords {

    private final class TrieNode {

        private final TrieNode[] children;

        private boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }

        public void insert(TrieNode root, String dict) {
            for (char ch : dict.toCharArray()) {
                if (root.children[ch - 'a'] == null) {
                    root.children[ch - 'a'] = new TrieNode();
                }
                root = root.children[ch - 'a'];
            }
            root.isEndOfWord = true;
        }

        public String getRootWord(TrieNode root, String word) {
            StringBuilder sb = new StringBuilder();
            // iterating over every character of string
            for (char ch : word.toCharArray()) {
                sb.append(ch);
                // if the character in target string not exists in Trie
                if (root.children[ch - 'a'] == null) {
                    return null;
                }
                if (root.children[ch - 'a'].isEndOfWord) {
                    return sb.toString();
                }
                root = root.children[ch - 'a'];
            }
            return root.isEndOfWord ? sb.toString() : null;
        }
    }

    private String replaceWords(List<String> dictionary, String sentence) {
        TrieNode prefixTree = new TrieNode();
        // construct a trie based on given dictionary
        for (String dict : dictionary) {
            prefixTree.insert(prefixTree, dict);
        }
        String[] splits = sentence.split(" "); // split based on space
        StringBuilder repalcedSentence = new StringBuilder();
        for (String split : splits) {
            String root = prefixTree.getRootWord(prefixTree, split);
            repalcedSentence.append(Objects.requireNonNullElse(root, split));
            repalcedSentence.append(" ");
        }
        return repalcedSentence.toString().trim();
    }

    public static void main(String[] args) {
        String[] dictionary = { "cat", "bat", "rat" };
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new ReplaceWords().replaceWords(Arrays.asList(dictionary), sentence));
        String[] dictionary2 = { "a", "b", "c" };
        sentence = "aadsfasf absbs bbab cadsfafs";
        System.out.println(new ReplaceWords().replaceWords(Arrays.asList(dictionary2), sentence));
    }
}
