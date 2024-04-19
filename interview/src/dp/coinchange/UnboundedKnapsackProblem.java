/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 * https://www.codingninjas.com/studio/problems/unbounded-knapsack_1215029
 *
 * Time Complexity : O(N * W)
 * Space Complexity : O(W)
 */
package dp.coinchange;

public class UnboundedKnapsackProblem {

        private int f(int n, int w, int[] profit, int[] weight) {
                // base case : at index-0
                if (n == 0) {
                        return (w / weight[0]) * profit[0];
                }
                int profitIfTaken = Integer.MIN_VALUE;
                if (weight[n] <= w) {
                        profitIfTaken = profit[n] + f(n, w - weight[n], profit, weight);
                }
                int profitIfNotTaken = f(n - 1, w, profit, weight);
                return Math.max(profitIfTaken, profitIfNotTaken);
        }

        private int fillKnapsack(int[] profit, int[] weight, int w, int n) {
                // recursive solution
                System.out.println(f(n - 1, w, profit, weight));
                // tabulation solution
                int[][] dp = new int[n][w + 1];
                for (int i = weight[0]; i <= w; ++i) {
                        dp[0][i] = (i / weight[0]) * profit[0];
                }
                for (int i = 1; i < n; ++i) {
                        for (int j = 0; j <= w; ++j) {
                                int profitIfTaken = Integer.MIN_VALUE;
                                if (weight[i] <= j) {
                                        profitIfTaken = profit[i] + dp[i][j - weight[i]];
                                }
                                int profitIfNotTaken = dp[i - 1][j];
                                dp[i][j] = Math.max(profitIfTaken, profitIfNotTaken);
                        }
                }
                return dp[n - 1][w];
        }

        // 1-D array approach (space optimized)
        private int fillKnapsack2(int[] profit, int[] weight, int w, int n) {
                // from recursion
                System.out.println(f(n, w, profit, weight));
                // dp[i] is going to store maximum value
                // with knapsack capacity i
                int[] dp = new int[w + 1];
                for (int i = 0; i <= w; ++i) {
                        for (int j = 0; j < n; ++j) {
                                if (profit[j] <= i) {
                                        dp[i] = Math.max(dp[i], profit[j] + dp[i - weight[j]]);
                                }
                        }
                }
                return dp[w];
        }

        public static void main(String[] args) {
                int w = 100;
                int profit[] = { 10, 30, 20 };
                int weight[] = { 5, 10, 15 };
                int n = profit.length;
                System.out.println(new UnboundedKnapsackProblem().fillKnapsack(profit, weight, w, n));
        }
}
