/**
 * Date 06/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/dungeon-game/description/
 *
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 */
package dp.path;

import java.util.Arrays;

public class DungeonGame {

    private int f(int[][] dungeon, int row, int col, int m, int n) {
        // base case
        if (row == m || col == n) {
            return Integer.MAX_VALUE;
        }
        int right = f(dungeon, row, col + 1, m, n);
        int down = f(dungeon, row + 1, col, m, n);
        int health = Math.min(right, down);
        // we reach the destination when both the sides return INT_MAX
        if (health == Integer.MAX_VALUE) {
            health = 1;
        }
        return (health - dungeon[row][col] <= 0) ? 1 : health - dungeon[row][col];
    }

    private int memorize(int[][] dungeon, int[][] dp, int row, int col, int m, int n) {
        // base case
        if (row == m || col == n) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int right = memorize(dungeon, dp, row, col + 1, m, n);
        int down = memorize(dungeon, dp, row + 1, col, m, n);
        int health = Math.min(right, down);
        // we reach the destination when both the sides return INT_MAX
        if (health == Integer.MAX_VALUE) {
            health = 1;
        }
        return dp[row][col] = (health - dungeon[row][col] <= 0) ? 1 : health - dungeon[row][col];
    }

    private int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // recursive
        System.out.println(f(dungeon, 0, 0, m, n));

        // memorization
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(memorize(dungeon, dp, 0, 0, m, n));

        // tabulation
        dp = new int[m][n];
        // copy first row
        System.arraycopy(dungeon[0], 0, dp[0], 0, n);
        // copy first column
        for (int i = 0; i < n; ++i) {
            dp[i][0] = dungeon[i][0];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                int health = Math.min(dp[i][j - 1], dp[i - 1][j]);
                dp[i][j] = (health - dungeon[i][j] <= 0) ? 1 : health - dungeon[i][j];
            }
        }
        return 1 + dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{ -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 }};
        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));
    }
}
