/**
 * https://leetcode.com/problems/burst-balloons/description/
 * https://www.codingninjas.com/studio/problems/mining-diamonds_4244494
 *
 * Time Complexity : O(N ^ 3)
 * Space Complexity : O(N ^ 2)
 * */
package dp.mcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBalloons {

    private int f(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            int cost = nums[i - 1] * nums[k] * nums[j + 1] + f(nums, i, k - 1) + f(nums, k + 1, j);
            max = Math.max(max, cost);
        }
        return max;
    }

    private int memoize(int[] nums, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            int cost = nums[i - 1] * nums[k] * nums[j + 1] + memoize(nums, i, k - 1, dp) + memoize(nums, k + 1, j, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }

    private int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        // convert into list
        for (int i : nums) {
            list.add(i);
        }
        list.add(1);
        nums = list.stream().mapToInt(i -> i).toArray();

        // recursion
        System.out.println(f(nums, 1, n));

        // memoization
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        memoize(nums, 1, n, dp);
        System.out.println(dp[1][n]);

        // tabulation
        dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; --i) {
            for (int j = i; j <= n; ++j) {
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i; k <= j; ++k) {
                    int coins = (nums[i - 1] * nums[k] * nums[j + 1]) + dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 8 };
        System.out.println(new BurstBalloons().maxCoins(nums));
    }
}
