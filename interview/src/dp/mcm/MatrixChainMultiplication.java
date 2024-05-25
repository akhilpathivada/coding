/**
 * https://www.codingninjas.com/studio/problems/matrix-chain-multiplication_975344
 *
 * Time Complexity: O(N ^ 3)
 * Space Complexity: O(N ^ 2)
 * */
package dp;

public class MatrixChainMultiplication {

    // Matrix Ai has dimension arr[i-1] arr p[i] for i = 1..n
    private int matrixMultiplication(int[] arr, int n) {
        // taking one extra row and column: but these will never be used
        int[][] dp = new int[n][n];
        // compute cost for matrices of length 1
        // cost is zero when multiplying 1 matrix
        for (int i = 1; i < n; ++i) {
            dp[i][i] = 0;
        }
        // compute cost for matrices starting from length 2 to length (n - 1)
        for (int l = 2; l < n; ++l) {
            for (int i = 1; i < n - l + 1; ++i) {
                int j = i + l - 1;
                if (j == n) {
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; ++k) {
                    int cost = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(new MatrixChainMultiplication().matrixMultiplication(arr, arr.length));
    }
}
