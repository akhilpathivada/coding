/**
 * https://leetcode.com/problems/prefix-and-suffix-search/description/
 *
 * Time Complexity: O(N * L) + Q(L + N)  where N -> no. of words, L -> length of the word, Q -> no. of queries
 * Space Complexity: O(N * L)
 * */
package advanced.trie;

public class MapSumPairs {

    private static class TrieNode {
        private final TrieNode[] trie;
        private boolean isEndOfWord;
        private int val;

        public TrieNode() {
            this.trie = new TrieNode[26];
            this.isEndOfWord = false;
            this.val = 0;
        }
    }

    private static class MapSum {
        TrieNode prefixTree;
        public MapSum() {
            prefixTree = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode root = prefixTree;
            for (char ch : key.toCharArray()) {
                if (root.trie[ch - 'a'] == null) {
                    root.trie[ch - 'a'] = new TrieNode();
                }
                root = root.trie[ch - 'a'];
            }
            root.val = val;
            root.isEndOfWord = true;
        }

        public int sum(String prefix) {
            TrieNode root = prefixTree;
            int sum = 0;
            for (char ch : prefix.toCharArray()) {
                if (root.trie[ch - 'a'] == null) {
                    return sum;
                }
                root = root.trie[ch - 'a'];
            }
            return dfs(root);
        }

        private int dfs(TrieNode root) {
            int sum = 0;
            if (root.isEndOfWord) {
                sum = root.val;
            }
            for (int i = 0; i < 26; ++i) {
                if (root.trie[i] != null) {
                    sum += dfs(root.trie[i]);;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        String key1 = "apple", key2 = "app";
        int value1 = 3, value2 = 2;
        MapSum mapSum = new MapSum();
        mapSum.insert(key1, value1);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert(key2, value2);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert(key1, value2);
        System.out.println(mapSum.sum("ap"));

        key1 = "appled"; key2 = "apple";
        value1 = 2; value2 = 3;
        MapSum mapSum2 = new MapSum();
        mapSum2.insert(key1, value1);
        System.out.println(mapSum2.sum("ap"));
        mapSum2.insert(key2, value2);
        System.out.println(mapSum2.sum("ap"));
        mapSum2.insert(key2, value1);
        System.out.println(mapSum2.sum("a"));
//        mapSum2.insert(key2, value1);
    }
}
