/**
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(N * log(N))
 * */
package dp;

import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // Sort the envelopes in ascending order of width and descending order of height
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // copy the heights
        int[] heights = new int[n];
        for (int i = 0; i < n; ++i) {
            heights[i] = envelopes[i][1];
        }
        int[] dp = new int[n];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if (index == len) {
                ++len;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(envelopes));
    }
}
