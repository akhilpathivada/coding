/**
 * Date 29/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/coin-change/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 */
package dp.coinchange;

import java.util.Arrays;

public class CoinChangeMinimum {

    private int f(int[] coins, int amount, int n) {
        if (amount == 0) {
            return 0;
        }
        if (n == 0) {
            return (amount % coins[n] == 0) ? (amount / coins[0]) : Integer.MAX_VALUE;
        }
        int taken = Integer.MAX_VALUE;
        if (coins[n] <= amount) {
            taken = 1 + f(coins, amount - coins[n], n);
        }
        int notTaken = f(coins, amount, n - 1);
        return Math.min(taken, notTaken);
    }

    private int minCoins(int[] coins, int amount) {
        int n = coins.length;
        // recursive solution
        System.out.println(f(coins, amount, n - 1));
        if (amount == 0) {
            return 0;
        }
        // tabulation solution
        int[][] dp = new int[n][amount + 1];
        // Initialize the dp array for the first element of the array
        for (int i = 0; i <= amount; ++i) {
            dp[0][i] = (i % coins[0] == 0) ? (i / coins[0]) : Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= amount; ++j) {
                int taken = Integer.MAX_VALUE;
                if (coins[i] <= j) {
                    taken = 1 + dp[i][j - coins[i]];
                }
                int notTaken = dp[i - 1][j];
                dp[i][j] = Math.min(taken, notTaken);
            }
        }
        return dp[n - 1][amount];
    }

    // using 1-D array (space optimized solution)
    private int minCoins2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // tabulation solution
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {

            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int n = 93;
        System.out.println(new CoinChangeMinimum().minCoins(coins, n));
    }

}
