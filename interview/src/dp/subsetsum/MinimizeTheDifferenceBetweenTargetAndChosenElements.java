
/**
 * Date 05/04/24
 * @author akhilpathivada
 *
 */
package dp.subsetsum;

import java.util.Arrays;
public class MinimizeTheDifferenceBetweenTargetAndChosenElements {

    private int f(int[][] mat, int target, int sum, int row) {
        // base case
        if (row < 0) {
            return Math.abs(target - sum);
        }
        int minDiff = Integer.MAX_VALUE;
        for (int col = 0; col < mat[row].length; ++col) {
            minDiff = Math.min(minDiff, f(mat, target, sum + mat[row][col], row - 1));
        }
        return minDiff;
    }

    private int memorize(int[][] mat, int[][] dp, int target, int sum, int row) {
        // base case
        if (row < 0) {
            return Math.abs(target - sum);
        }
        if (dp[row][sum] != -1) {
            return dp[row][sum];
        }
        int minDiff = Integer.MAX_VALUE;
        for (int col = 0; col < mat[0].length; ++col) {
            minDiff = Math.min(minDiff, memorize(mat, dp, target, sum + mat[row][col], row - 1));
        }
        return dp[row][sum] = minDiff;
    }

    private int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        // recursive
        System.out.println(f(mat, target, 0, m - 1));
        // memorization
        int[][] dp = new int[m][71 * 71];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memorize(mat, dp, target, 0, m - 1);
    }

    public static void main(String[] args) {
        int[][] mat = {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
        int target = 13;
        System.out.println(new MinimizeTheDifferenceBetweenTargetAndChosenElements().minimizeTheDifference(mat, target));
    }
}
