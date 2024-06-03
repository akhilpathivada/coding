/**
 * https://www.codingninjas.com/studio/problems/count-distinct-substrings_985292
 *
 * Time Complexity: O(N ^ 3)
 * Space Complexity: O(N ^ 2)
 * */
package trie;

import trie.base.TrieNode;

public class CountDistinctSubstrings {

    private int countDistinctSubstrings(String s) {
        // include empty string
        int countOfDistinctSubstrings = 1;
        TrieNode root = new TrieNode();
        // generate all the substrings
        for (int i = 0; i < s.length(); ++i) {
            TrieNode current = root;
            for (int j = i; j < s.length(); ++j) {
                // substring is not present
                // add it into trie and increment the distinct count by 1
                if (current.trie[s.charAt(j)] == null) {
                    current.trie[s.charAt(j)] = new TrieNode();
                    ++countOfDistinctSubstrings;
                }
                current = current.trie[s.charAt(j)];
            }
        }
        return countOfDistinctSubstrings;
    }

    public static void main(String[] args) {
        String s = "sds";
        System.out.println(new CountDistinctSubstrings().countDistinctSubstrings(s));
    }
}
