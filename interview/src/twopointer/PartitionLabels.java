/**
 * https://leetcode.com/problems/partition-labels/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package twopointer;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    private List<Integer> partitionLabels(String s) {
        // base case
        if (s == null || s.isEmpty()) {
            return null;
        }
        final List<Integer> output = new ArrayList<>();
        // stores the index of last occurrence of a character
        final int[] lastOccurence = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            lastOccurence[s.charAt(i) - 'a'] = i;
        }
        int startingIndexOfChar = 0;
        int endingIndexOfChar = 0;
        for (int i = 0; i < s.length(); ++i) {
            endingIndexOfChar = Math.max(endingIndexOfChar, lastOccurence[s.charAt(i) - 'a']);
            // found the first partition
            if (i == endingIndexOfChar) {
                output.add(endingIndexOfChar - startingIndexOfChar + 1);
                startingIndexOfChar = endingIndexOfChar + 1;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(new PartitionLabels().partitionLabels(s));
    }
}
