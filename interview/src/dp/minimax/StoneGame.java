/**
 * Date 10/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/stone-game/description/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N ^ 2)
 */
package dp.minimax;

import java.util.Arrays;

public class StoneGame {

    private int f(int[] piles, int i, int j) {
        if (i > j) {
            return 0;
        }
        return Math.max(piles[i] - f(piles, i + 1, j),
                piles[j] - f(piles, i, j - 1));
    }

    private int memorize(int[] piles, int[][] dp, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = Math.max(piles[i] - memorize(piles, dp, i + 1, j),
                piles[j] - memorize(piles, dp, i, j - 1));
    }

    private boolean stoneGame(int[] piles) {
        int n = piles.length;
        // recursive
        System.out.println(f(piles, 0, n - 1) > 0);

        // memorization
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(memorize(piles, dp, 0, n - 1) > 0);

        // tabulation
        dp = new int[n][n];
        for (int i = 0; i < n - 1; ++i) {
            for (int j = n - 1; j > 0; --j) {
                if (i > j) {
                    continue;
                }
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        System.out.println(new StoneGame().stoneGame(piles));
    }
}
