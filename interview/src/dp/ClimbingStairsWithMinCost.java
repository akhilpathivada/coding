/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * */
package dp;

public class ClimbingStairsWithMinCost {

    private int minCostClimbingStairs(int[] cost) {
        // base case
        if (cost == null) {
            return 0;
        }
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; ++i) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(new ClimbingStairsWithMinCost().minCostClimbingStairs(cost));
    }
}
