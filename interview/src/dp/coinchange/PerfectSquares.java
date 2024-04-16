/**
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * */
package dp.coinchange;

public class PerfectSquares {

    private int numSquares(int n) {
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
        int n = 5;
        System.out.println(new PerfectSquares().numSquares(n));
    }
}
