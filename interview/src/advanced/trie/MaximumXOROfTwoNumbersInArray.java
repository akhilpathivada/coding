/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * https://www.codingninjas.com/studio/problems/maximum-xor_3119012
 *
 * Time Complexity: O(N * 32) + O(M * 32). Reason: For inserting all the elements of arr1 into the trie take O(N*32) [32 Bit] and O(M*32) for finding the maxXOR for every element of arr2.
 * Space Complexity: O(N * 32)
 *
 * */
package advanced.trie;

public class MaximumXOROfTwoNumbersInArray {

    private TrieNode root;

    private class TrieNode {

        private final TrieNode[] node; // each characters' index acts as a pointer

        public TrieNode() {
            node = new TrieNode[2];
            // iterates over 2 indexes and initializes as null
            for (int i = 0; i < 2; ++i) {
                node[i] = null;
            }
        }

        private void insertNumberIntoTrie(int num) {
            TrieNode current = root;
            for (int i = 31; i >= 0; --i) {
                int bit = (num >> i) & 1;
                if (current.node[bit] == null) {
                    current.node[bit] = new TrieNode();
                }
                current = current.node[bit];
            }
        }

        private int getMaximumXOR(int num) {
            TrieNode current = root;
            int maximumXOR = 0;
            for (int i = 31; i >= 0; --i) {
                int bit = (num >> i) & 1;
                // the required bit: inverse of bit
                if (current.node[1 - bit] != null) {
                    maximumXOR = maximumXOR | (1 << i);
                    current = current.node[1 - bit];
                } else {
                    current = current.node[bit];
                }
            }
            return maximumXOR;
        }
    }

    private int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        // insert numbers into trie in form of binary bits
        for (int num : nums) {
            root.insertNumberIntoTrie(num);
        }
        int maximumXOR = Integer.MIN_VALUE;
        for (int num : nums) {
            maximumXOR = Math.max(maximumXOR, root.getMaximumXOR(num));
        }
        return maximumXOR;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 10, 5, 25, 2, 8 };
        System.out.println(new MaximumXOROfTwoNumbersInArray().findMaximumXOR(nums));
    }
}
