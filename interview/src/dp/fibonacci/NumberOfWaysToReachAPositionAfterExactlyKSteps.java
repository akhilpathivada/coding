package dp.fibonacci;

import java.util.Arrays;

/**
 * Date 19/04/24
 * Time 12:25
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/description/
 *
 *
 */
public class NumberOfWaysToReachAPositionAfterExactlyKSteps {

    private static final int MOD = (int) 1e9 + 7;

    private int f(int currentPos, final int endPos, int k) {
        if (k == 0 && currentPos == endPos) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        return (f(currentPos + 1, endPos, k - 1) + f(currentPos - 1, endPos, k - 1)) % MOD;
    }

    private int memoize(final int[][] dp, int currentPos, final int endPos, int k) {
        if (k == 0 && currentPos == endPos) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[currentPos + 2000][k] != -1) {
            return dp[currentPos + 2000][k];
        }
        return dp[currentPos + 2000][k] = (memoize(dp, currentPos + 1, endPos, k - 1) + memoize(dp, currentPos - 1, endPos, k - 1)) % MOD;
    }

    private int numberOfWays(int startPos, int endPos, int k) {
        // recursive
        System.out.println(f(startPos, endPos, k));
        // memoization
        // based on the given constraints:
        // startPos might go into -ve side as well
        int[][] dp = new int[4001][1001];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memoize(dp, startPos, endPos, k);
    }

    public static void main(String[] args) {
        int startPos = 1, endPos = 2, k = 3;
        System.out.println(new NumberOfWaysToReachAPositionAfterExactlyKSteps().numberOfWays(startPos, endPos, k));
    }
}
