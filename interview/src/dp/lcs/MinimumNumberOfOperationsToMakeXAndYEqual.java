/**
 * author: akhilpathivada
 * time: 08/05/24 07:35
 *
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/description/
 *
 */
package dp.lcs;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMakeXAndYEqual {

    private int f(int x, int y) {
        if (y >= x) {
            return y - x;
        }
        if (x <= 0) {
            return Integer.MAX_VALUE;
        }
        int numOfOpsWhileDividingBy5;
        int numOfOpsWhileDividingBy11;
        if (x % 5 == 0) {
            numOfOpsWhileDividingBy5 = 1 + f(x / 5, y);
        } else {
            // find closest num. to x divisible that is divisible by 5
            int closest = x + (5 - (x % 5));
            // first we increment x by (closest - x) operations
            // then we do the "divide by 5" operation
            // hence total operation is (closest - x) + 1
            numOfOpsWhileDividingBy5 = (closest - x) + 1 + f(closest / 5, y);
        }
        if (x % 11 == 0) {
            numOfOpsWhileDividingBy11 = 1 + f(x / 11, y);
        } else {
            // find closest num. to x divisible that is divisible by 11
            int closest = x + (11 - (x % 11));
            // first we increment x by (closest - x) operations
            // then we do the "divide by 11" operation
            // hence total operation is (closest - x) + 1
            numOfOpsWhileDividingBy11 = (closest - x) + 1 + f(closest / 11, y);
        }
        int numOfOpsWhileDecrementingBy1 = 1 + f(x - 1, y);
        return Math.min(numOfOpsWhileDecrementingBy1, Math.min(numOfOpsWhileDividingBy5, numOfOpsWhileDividingBy11));
    }

    private int memoize(int x, int y, int[] dp) {
        if (y >= x) {
            return y - x;
        }
        if (x <= 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[x] != -1) {
            return dp[x];
        }
        int numOfOpsWhileDividingBy5;
        if (x % 5 == 0) {
            numOfOpsWhileDividingBy5 = 1 + memoize(x / 5, y, dp);
        } else {
            // find closest num. to x divisible that is divisible by 5
            int closest = x + (5 - (x % 5));
            // first we increment x by (closest - x) operations
            // then we do the "divide by 5" operation
            // hence total operation is (closest - x) + 1
            numOfOpsWhileDividingBy5 = (closest - x) + 1 + memoize(closest / 5, y, dp);
        }
        int numOfOpsWhileDividingBy11;
        if (x % 11 == 0) {
            numOfOpsWhileDividingBy11 = 1 + memoize(x / 11, y, dp);
        } else {
            // find closest num. to x divisible that is divisible by 11
            int closest = x + (11 - (x % 11));
            // first we increment x by (closest - x) operations
            // then we do the "divide by 11" operation
            // hence total operation is (closest - x) + 1
            numOfOpsWhileDividingBy11 = (closest - x) + 1 + memoize(closest / 11, y, dp);
        }
        int numOfOpsWhileDecrementingBy1 = 1 + memoize(x - 1, y, dp);
        return dp[x] = Math.min(numOfOpsWhileDecrementingBy1, Math.min(numOfOpsWhileDividingBy5, numOfOpsWhileDividingBy11));
    }

    private int minimumOperationsToMakeEqual(int x, int y) {
        // recursion
        System.out.println(f(x, y));

        // memoization
        final int[] dp = new int[10011];
        Arrays.fill(dp, -1);
        return memoize(x, y, dp);
    }

    public static void main(String[] args) {
        int x = 26, y = 1;
        System.out.println(new MinimumNumberOfOperationsToMakeXAndYEqual().minimumOperationsToMakeEqual(x, y));
    }
}
