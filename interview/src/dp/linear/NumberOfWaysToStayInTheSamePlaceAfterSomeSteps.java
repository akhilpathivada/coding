/**
 * author: akhilpathivada
 * time: 09/06/24 12:20
 *
 * https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/
 *
 */
package dp.linear;

import java.util.Arrays;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    private final int MOD = (int) 1e9 + 7;

    private int f(int steps, int arrLen, int position) {
        if (position < 0 || position == arrLen) {
            return 0;
        }
        if (steps == 0) {
            return position == 0 ? 1 : 0;
        }
        return ((f(steps - 1, arrLen, position) % MOD
                + f(steps - 1, arrLen, position + 1) % MOD) % MOD
                + f(steps - 1, arrLen, position - 1) % MOD) % MOD;
    }

    private int memoize(int steps, int arrLen, int position, int[][] dp) {
        if (position < 0 || position == arrLen) {
            return 0;
        }
        if (steps == 0) {
            return position == 0 ? 1 : 0;
        }
        if (dp[steps][position] != -1) {
            return dp[steps][position];
        }
        return dp[steps][position] = ((memoize(steps - 1, arrLen, position, dp) % MOD
                + memoize(steps - 1, arrLen, position + 1, dp) % MOD) % MOD
                + memoize(steps - 1, arrLen, position - 1, dp) % MOD) % MOD;
    }

    public int numWays(int steps, int arrLen) {
        // recursion
        System.out.println(f(steps, arrLen, 0));

        // memoization
        final int[][] dp = new int[steps + 1][steps + 2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return memoize(steps, arrLen, 0, dp);
    }

    public static void main(String[] args) {
        int steps = 3, arrLen = 2;
        System.out.println(new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps().numWays(steps, arrLen));
    }
}
