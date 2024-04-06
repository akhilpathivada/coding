/**
 * Date 06/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/
 *
 * Time Complexity: O(m * n * k)
 * Space Complexity: O(m * n * k)
 */
package dp.threedimension;


import java.util.Arrays;

public class PathsInMatrixWhoseSumIsDivisibleByK {

    private static final int MOD = (int) (Math.pow(10, 9) + 7);

    private int f(int[][] grid, int k, int sum, int i, int j) {
        // base case
        if (i < 0 || j < 0) {
            return 0;
        }
        // reach destination
        if (i == 0 && j == 0 && (sum + grid[i][j]) % k == 0) {
            return 1;
        }
        return f(grid, k, sum + grid[i][j], i - 1, j) + f(grid, k, sum + grid[i][j], i, j - 1);
    }

    private int memorize(int[][] grid, int[][][] dp, int k, int sum, int i, int j) {
        // base case
        if (i < 0 || j < 0) {
            return 0;
        }
        // reach destination
        if (i == 0 && j == 0 && (sum + grid[i][j]) % k == 0) {
            return 1;
        }
        if (dp[i][j][sum % k] != -1) {
            return dp[i][j][sum % k];
        }
        return dp[i][j][sum % k] = (memorize(grid, dp, k, sum + grid[i][j], i - 1, j) + memorize(grid, dp, k, sum + grid[i][j], i, j - 1)) % MOD;
    }

    private int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        System.out.println(f(grid, k, 0, m - 1, n - 1));
        int[][][] dp = new int[m][n][k];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return memorize(grid, dp, k, 0, m - 1, n - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{ 5, 2, 4 }, { 3, 0, 5 }, { 0, 7, 2 }};
        int k = 3;
        System.out.println(new PathsInMatrixWhoseSumIsDivisibleByK().numberOfPaths(grid, k));
    }
}
