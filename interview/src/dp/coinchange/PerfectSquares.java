/**
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * */
package dp.coinchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {

    private int f(int i, int n) {
        if (i == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        int square = i * i;
        int taken = Integer.MAX_VALUE;
        if (square <= n) {
            taken = 1 + f(i, n - square);
        }
        int notTaken = f(i - 1, n);
        return Math.min(taken, notTaken);
    }

    private int memoize(int[][] dp, int i, int n) {
        if (i == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        if (dp[i][n] != -1) {
            return dp[i][n];
        }
        int square = i * i;
        int taken = Integer.MAX_VALUE;
        if (square <= n) {
            taken = 1 + memoize(dp, i, n - square);
        }
        int notTaken = memoize(dp, i - 1, n);
        return dp[i][n] = Math.min(taken, notTaken);
    }


    private int numSquares(int n) {
        // recursive solution
        System.out.println(f(n, n));
        // memoization
        int[][] dp2 = new int[n + 1][n + 1];
        for (int[] d : dp2) {
            Arrays.fill(d, -1);
        }
        System.out.println(memoize(dp2, n, n));
        // tabulation
        // can be done with 2D dp matrix, but memory efficient way is to use 1D dp array
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new PerfectSquares().numSquares(n));
    }
}
