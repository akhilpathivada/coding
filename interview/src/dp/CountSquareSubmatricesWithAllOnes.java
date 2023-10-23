/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * */
package dp;

public class CountSquareSubmatricesWithAllOnes {

    private int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                sum += dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(matrix));
    }
}
