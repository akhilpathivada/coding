/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    private int longestConsecutive(int[] nums) {
        int maxSequenceLength = 0;
        Set<Integer> set = new HashSet<>();
        // insert elements into set
        for (int num : nums) {
            set.add(num);
        }
        // iterate over the set
        for (int n : set) {
            // assume the sequence starts here and check (n+1), (n+2), (n+3).... exists
            int m = n + 1;
            // if the sequence starts here: means, n - 1 should not exist
            if (!set.contains(n - 1)) {
                while (set.contains(m)) {
                    ++m;
                }
            }
            maxSequenceLength = Math.max(maxSequenceLength, m - n);
        }
        return maxSequenceLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 9, 3, 10, 4, 20, 2 };
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }
}
