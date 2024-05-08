/**
 * author: akhilpathivada
 * time: 08/05/24 17:56
 *
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/
 */
package dp.coinchange;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {

    private static final int MOD = (int) 1e9 + 7;

    private int f(int n, int k, int target) {
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }
        int count = 0;
        for (int diceRollValue = 1; diceRollValue <= k; ++diceRollValue) {
            count = (count + f(n - 1, k, target - diceRollValue)) % MOD;
        }
        return count;
    }

    private int memoize(int n, int k, int target, int[][] dp) {
        if (n == 0 || target < 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        int count = 0;
        for (int diceRollValue = 1; diceRollValue <= k; ++diceRollValue) {
            count = (count + memoize(n - 1, k, target - diceRollValue, dp)) % MOD;
        }
        return dp[n][target] = count;
    }

    private int numRollsToTarget(int n, int k, int target) {
        // recursion
        System.out.println(f(n, k, target));

        // memoization
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(memoize(n, k, target, dp));

        // tabulation
        dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= target; ++j) {
                int count = 0;
                for (int diceRollValue = 1; diceRollValue <= k; ++diceRollValue) {
                    if (j - diceRollValue >= 0) {
                        count = (count + dp[i - 1][j - diceRollValue]) % MOD;
                    }
                }
                dp[i][j] = count;
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(n, k, target));
    }
}
