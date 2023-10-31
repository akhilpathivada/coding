/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N ^ 2)
 */
package dp;

import java.util.Arrays;

public class RodCuttingProblem {

        // recursive approach
        private int f(int[] prices, int n, int index) {
                // base case
                if (index == 0) {
                        return n * prices[0];
                }
                int rodLength = index + 1;
                int taken = Integer.MIN_VALUE;
                if (rodLength <= n) {
                        taken = prices[index] + f(prices, n - rodLength, index);
                }
                int notTaken = f(prices, n, index - 1);
                return Math.max(taken, notTaken);
        }

        // top down
        private int topDown(int[] prices, int n, int index, int[][] dp) {
                // base case
                if (index == 0) {
                        return n * prices[0];
                }
                if (dp[index][n] != -1) {
                        return dp[index][n];
                }
                int rodLength = index + 1;
                int taken = Integer.MIN_VALUE;
                if (rodLength <= n) {
                        taken = prices[index] + topDown(prices, n - rodLength, index, dp);
                }
                int notTaken = topDown(prices, n, index - 1, dp);
                return dp[index][n] = Math.max(taken, notTaken);
        }

        private int cutRod(int[] prices, int n) {
                // recursive solution
                System.out.println(f(prices, n, n - 1));
                // top down solution
                int[][] dp = new int[n][n + 1];
                for (int[] row : dp) {
                        Arrays.fill(row, - 1);
                }
                System.out.println(topDown(prices, n, n - 1, dp));
                // tabulation solution
                if (n == 0) {
                        return 0;
                }
                int[][] table = new int[n + 1][n + 1];
                // row : denotes of how much length we want to cut(profit assigned to it)
                // column : denotes for what of length of rod we want to cut
                for (int i = 0; i <= n; ++i) {
                        for (int j = 0; j <= n; ++j) {
                                if (i == 0 || j == 0) { // if length of rod is 0, or we want to cut into length of 0
                                        table[i][j] = 0;
                                } else if (i > j) {
                                        table[i][j] = table[i - 1][j];
                                } else {
                                        table[i][j] = Math.max(table[i - 1][j], table[i][j - i] + prices[i - 1]);
                                }
                        }
                }
                return table[n][n];
        }

        public static void main(String[] args) {
                int[] prices = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
                int n = prices.length;
                System.out.println("Maximum obtained value is = " + new RodCuttingProblem().cutRod(prices, n));
        }
}
