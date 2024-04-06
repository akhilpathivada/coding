/**
 * https://leetcode.com/problems/last-stone-weight-ii/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * */
package dp.subsetsum;

import java.util.Arrays;

public class LastStoneWeightII {

    // logic: isSubsetSum()
    private int getSumClosestToHalfSum(int[] set, int sum, int n) {
        boolean[][] table = new boolean[n + 1][sum + 1];
        int maxSum = Integer.MIN_VALUE;
        // If sum is 0, then answer is true
        for (int i = 0; i <= n; ++i) {
            table[i][0] = true;
        }
        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; ++i) {
            table[0][i] = false;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (set[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = table[i - 1][j - set[i - 1]] || table[i - 1][j];
                }
                if (table[i][j]) {
                    maxSum = Math.max(maxSum, j);
                }
            }
        }
        return maxSum;
    }

    public int lastStoneWeightII(int[] stones) {
        int totalSum = Arrays.stream(stones).sum();
        // find the sum which is closest to half of the total sum
        // and reduce it from the total sum to get the min. weight of last stone left
        return totalSum - 2 * getSumClosestToHalfSum(stones, totalSum / 2, stones.length);
    }

    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(new LastStoneWeightII().lastStoneWeightII(stones));
    }
}
