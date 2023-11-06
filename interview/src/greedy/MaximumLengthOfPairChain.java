/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(N * log(N))
 * */
package greedy;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

    private int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        // b[1], a[1] because we need the 2nd values in descending order
        Arrays.sort(pairs, (a, b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int lengthOfChain = 1;
        int max = pairs[n - 1][0];
        for (int i = n - 2; i >= 0; --i) {
            if (max > pairs[i][1]) {
                ++lengthOfChain;
                max = pairs[i][0];
            }
        }
        return lengthOfChain;
    }

    public static void main(String[] args) {
        int[][] pairs = { { -10, -8 }, { 8, 9 }, { -5, 0 }, { 6, 10 }, { -6, -4 }, { 1, 7 }, { 9, 10 }, { -4, 7 } };
        System.out.println(new MaximumLengthOfPairChain().findLongestChain(pairs));
    }
}
