/**
 * Date 24/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * https://leetcode.com/problems/coin-change-ii/
 *
 * Time Complexity: O(m * n)
 * Space Complexity : O(m * n)
 *
 */
package dp;

import java.util.Arrays;

public class CoinChangeWaysII {

        // recursive solution
        private int f(int[] coins, int n, int amount) {
                // Base case: If the current index is 0
                if (n == 0) {
                        return (amount % coins[0] == 0) ? 1 : 0;
                }
                int taken = 0;
                if (coins[n] <= amount) {
                        taken = f(coins, n , amount - coins[n]);
                }
                int notTaken = f(coins, n - 1, amount);
                return taken + notTaken;
        }

        // top-down approach
        private int topDown(int[] coins, int n, int amount, int[][] dp) {
                if (n == 0) {
                        dp[n][amount] = (amount % coins[0] == 0) ? 1 : 0;
                }
                if (dp[n][amount] != -1) {
                        return dp[n][amount];
                }
                int taken = 0;
                if (coins[n] <= amount) {
                        taken = topDown(coins, n , amount - coins[n], dp);
                }
                int notTaken = topDown(coins, n - 1, amount, dp);
                return dp[n][amount] = taken + notTaken;
        }

        private int coinChange(int[] coins, int n, int amount) {
                // recursive solution
                System.out.println(f(coins, n - 1, amount));
                // top-down solution
                int[][] dp = new int[n][amount + 1];
                for (int[] row : dp) {
                        Arrays.fill(row, -1);
                }
                System.out.println(topDown(coins, n - 1, amount, dp));
                // tabulation solution
                dp = new int[n][amount + 1];
                for (int i = 0; i <= amount; ++i) {
                        dp[0][i] = (i % coins[0] == 0) ? 1 : 0;
                }
                for (int i = 1; i < n; ++i) {
                        for (int j = 0; j <= amount; ++j) {
                                int taken = 0;
                                if (coins[i] <= j) {
                                        taken = dp[i][j - coins[i]];
                                }
                                int notTaken = dp[i - 1][j];
                                dp[i][j] = taken + notTaken;
                        }
                }
                return dp[n - 1][amount];
        }

        // using 1-D array (space optimized solution)
        private int coinChange2(int[] coins, int n, int amount) {
                // table[i] will be storing the number of solutions for
                // value i. We need n+1 rows as the table is constructed
                // in bottom up manner using the base case (n = 0)
                int[] table = new int[amount + 1];
                // Base case (If given value is 0)
                table[0] = 1;
                // Pick all coins one by one and update the table[] values
                // after the index greater than or equal to the value of the picked coin
                for (int i = 0; i < n; ++i) {
                        for (int j = coins[i]; j <= amount; ++j) {
                                table[j] += table[j - coins[i]];
                        }
                }
                return table[n];
        }
        
        public static void main(String[] args) {
                int[] coins = { 1, 2, 3 };
                int amount = 4;
                System.out.println("Number of ways we can change = "
                        + new CoinChangeWaysII().coinChange(coins, coins.length, amount));
        }
}
