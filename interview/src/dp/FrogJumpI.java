/**
 * https://www.codingninjas.com/studio/problems/frog-jump_3621012
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 * */
package dp;

public class FrogJumpI {

    public int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(heights[0] - heights[1]);
        for (int i = 2; i < n; ++i) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(heights[i] - heights[i - 1]),
                    dp[i - 2] + Math.abs(heights[i] - heights[i - 2]));
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] heights = { 10, 20, 30, 10 };
        System.out.println(new FrogJumpI().frogJump(heights.length, heights));
    }
}
