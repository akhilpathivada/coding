/**
 * https://leetcode.com/problems/burst-balloons/description/
 * https://www.codingninjas.com/studio/problems/mining-diamonds_4244494
 *
 * Time Complexity : O(N ^ 3)
 * Space Complexity : O(N ^ 2)
 * */
package dp;

import java.util.ArrayList;
import java.util.List;

public class BurstBalloons {

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
        int[][] dp = new int[n + 2][n + 2];
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
