/**
 * https://leetcode.com/problems/candy/
 *
 * 2 - Arrays Approach
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */

package greedy;

import java.util.Arrays;

public class MinimumCandiesDistributionI {

        private int minCandies(int[] ratings) {

                final int n = ratings.length;
                final int[] L = new int[n];
                final int[] R = new int[n];
                int candiesNeeded = 0;
                // filling initial values
                Arrays.fill(L, 1);
                Arrays.fill(R, 1);
                // compute candies based on left neighbour
                for (int i = 1; i < n; ++i) {
                        if (ratings[i] > ratings[i - 1]) {
                                L[i] = L[i - 1] + 1;
                        }
                }
                // compute candies based on right neighbour
                for (int i = n - 2; i >= 0; --i) {
                        if (ratings[i] > ratings[i + 1]) {
                                R[i] = R[i + 1] + 1;
                        }
                }
                // merge both the sides
                for (int i = 0; i < n; ++i) {
                        candiesNeeded += Math.max(L[i], R[i]);
                }
                return candiesNeeded;
        }

        public static void main(String[] args) {
                int[] ratings = { 1, 0, 2 };
                System.out.println(new MinimumCandiesDistributionI().minCandies(ratings));
        }
}
