/**
 * Date 10/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/predict-the-winner/description/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N ^ 2)
 */
package dp.minimax;

import java.util.Arrays;

public class PredictTheWinner {

    private int f(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        return Math.max(nums[i] - f(nums, i + 1, j),
                nums[j] - f(nums, i, j - 1));
    }

    private int memorize(int[] nums, int[][] dp, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = Math.max(nums[i] - memorize(nums, dp, i + 1, j),
                nums[j] - memorize(nums, dp, i, j - 1));
    }

    private boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // recursive
        System.out.println(f(nums, 0, n - 1) > 0);

        // memorization
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(memorize(nums, dp, 0, n - 1) > 0);

        // tabulation
        dp = new int[n][n];
        for (int i = 0; i < n - 1; ++i) {
            for (int j = n - 1; j > 0; --j) {
                if (i > j) {
                    continue;
                }
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.println(new PredictTheWinner().predictTheWinner(nums));
    }
}
