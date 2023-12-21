/**
 * https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
 * https://www.codingninjas.com/studio/problems/max-xor-queries_1382020
 *
 *
 * */
package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumXORWithAnElementFromArray {

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
            TrieNode current = this;
            for (int i = 31; i >= 0; --i) {
                int bit = (num >> i) & 1;
                if (current.node[bit] == null) {
                    current.node[bit] = new TrieNode();
                }
                current = current.node[bit];
            }
        }

        private int getMaximumXOR(int num) {
            TrieNode current = this;
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

    private int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        List<List<Integer>> offlineQueries = new ArrayList<>();
        int m = queries.length;
        for (int i = 0; i < m; ++i) {
            offlineQueries.add(Arrays.asList(queries[i][1], queries[i][0], i));
        }
        // sort the queries based on 2nd parameter
        offlineQueries.sort(Comparator.comparingInt(o -> o.get(0)));
        int[] result = new int[m];
        Arrays.fill(result, -1);
        int index = 0;
        root = new TrieNode();
        for (int i = 0; i < m; ++i) {
            while (index < nums.length && nums[index] <= offlineQueries.get(i).get(0)) {
                root.insertNumberIntoTrie(nums[index++]);
            }
            int queryIndex = offlineQueries.get(i).get(2);
            if (index != 0) {
                result[queryIndex] = root.getMaximumXOR(offlineQueries.get(i).get(1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4};
        int[][] queries = { { 3, 1 }, { 1, 3 }, { 5, 6 } };
        System.out.println(Arrays.toString(new MaximumXORWithAnElementFromArray().maximizeXor(nums, queries)));
    }
}
