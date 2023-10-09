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
package dp;

import java.util.Arrays;

public class CoinChangeMinimum {

    private int minCoins(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

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
