/**
 * https://leetcode.com/problems/candy/
 *
 * 1 - Array Approach
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */

package greedy;

import java.util.Arrays;

public class MinimumCandiesDistributionII {

        private int minCandies(int[] ratings) {
                final int n = ratings.length;
                // stores final results
                final int[] candies = new int[n];
                // filling initial values
                Arrays.fill(candies, 1);
                int candiesNeeded = 0;
                // compute candies based on left neighbour
                for (int i = 1; i < n; ++i) {
                        if (ratings[i] > ratings[i - 1]) {
                                candies[i] = candies[i - 1] + 1;
                        }
                }
                // compute candies based on right neighbour
                for (int i = n - 2; i >= 0; --i) {
                        if (ratings[i] > ratings[i + 1]) {
                                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
                        }
                }
                // sum of all candies
                for (int i = 0; i < n; ++i) {
                        candiesNeeded += candies[i];
                }
                return candiesNeeded;
        }

        public static void main(String[] args) {
                int[] ratings = { 1, 0, 2 };
                System.out.println(new MinimumCandiesDistributionII().minCandies(ratings));
        }
}
