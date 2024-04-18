package dp.coinchange;

import trie.MagicDictionary;

import java.util.Arrays;

/**
 * Date 18/04/24
 * Time 17:24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/description/
 *
 */
public class WaysToExpressAnIntegerAsSumOfPowers {

    private static final int MOD = (int) 1e9 + 7;

    private int f(int n, int x, int i) {
        if (n == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        int power = (int) Math.pow(i, x);
        int pick = 0;
        if (power <= n) {
            pick = f(n - power, x, i - 1);
        }
        int skip = f(n, x, i - 1);
        return pick + skip;
    }

    private int memoize(int[][] dp, int n, int x, int i) {
        if (n == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (dp[i][n] != -1) {
            return dp[i][n];
        }
        int power = (int) Math.pow(i, x);
        int pick = 0;
        if (power <= n) {
            pick = memoize(dp, n - power, x, i - 1);
        }
        int skip = memoize(dp, n, x, i - 1);
        return dp[i][n] = (pick % MOD + skip % MOD) % MOD;
    }

    private int numberOfWays(int n, int x) {
        // recursive
        System.out.println(f(n, x, n));
        // memoization
        int[][] dp = new int[n + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(memoize(dp, n, x, n));
        // tabulation
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int power = (int) Math.pow(i, x);
                int pick = 0;
                if (power <= j) {
                    pick = dp[i - 1][j - power];
                }
                int skip = dp[i - 1][j];
                dp[i][j] = (pick % MOD + skip % MOD) % MOD;
            }
        }
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        int n = 4, x = 1;
        System.out.println(new WaysToExpressAnIntegerAsSumOfPowers().numberOfWays(n, x));
    }
}
