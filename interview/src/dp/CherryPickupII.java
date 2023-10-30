/**
 * https://www.codingninjas.com/studio/problems/ninja-and-his-friends_3125885
 * https://leetcode.com/problems/cherry-pickup-ii/description/
 *
 * Time Complexity: O(N * M * M) * 9
 * Reason: The outer nested loops run for (N * M * M) times and the inner two nested loops run for 9 times.
 *
 * Space Complexity: O(N * M * M)
 * Reason: We are using an external array of size ‘N * M * M’. The stack space will be eliminated.
 * */
package dp;

public class CherryPickupII {

    private int cherryPickup(int m, int n, int[][] grid) {
        int[][][] dp = new int[m][n][n];
        // fill the last row
        for (int j1 = 0; j1 < n; ++j1) {
            for (int j2 = 0; j2 < n; ++j2) {
                if (j1 == j2) {
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                } else {
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }
        // bottom-up manner
        for (int i = m - 2; i >= 0; --i) {
            // alice
            for (int j1 = 0; j1 < n; ++j1) {
                // bob
                for (int j2 = 0; j2 < n; ++j2) {
                    // iterate over the combinations and get the max value
                    int max = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; ++dj1) {
                        int value = 0;
                        for (int dj2 = -1; dj2 <= 1; ++dj2) {
                            if (j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if ((j1 + dj1 >= 0) && (j1 + dj1 < n) && (j2 + dj2 >= 0) && (j2 + dj2 < n)) {
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            } else {
                                value = Integer.MIN_VALUE;
                            }
                            max = Math.max(max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 3, 1, 2 }, { 3, 4, 2, 2 }, { 5, 6, 3, 5 } };
        int m = grid.length;
        int n = grid[0].length;
        System.out.println(new CherryPickupII().cherryPickup(m, n, grid));
    }
}
