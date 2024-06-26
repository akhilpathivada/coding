package dp.minimax;

import java.util.Arrays;

/**
 * Date 10/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/stone-game-iii/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
public class StoneGameIII {

    private int f(int[] stoneValue, int index) {
        if (index == stoneValue.length) {
            return 0;
        }
        int stone = 0;
        int maxScore = Integer.MIN_VALUE;
        for (int k = 0; k < 3; ++k) {
            int i = index + k;
            if (i >= stoneValue.length) {
                break;
            }
            stone += stoneValue[i];
            int score = stone - f(stoneValue, i + 1);
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    private int memorize(int[] stoneValue, int[] dp, int index) {
        if (index == stoneValue.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int stone = 0;
        int maxScore = Integer.MIN_VALUE;
        for (int k = 0; k < 3; ++k) {
            int i = index + k;
            if (i >= stoneValue.length) {
                break;
            }
            stone += stoneValue[i];
            int score = stone - memorize(stoneValue, dp, i + 1);
            maxScore = Math.max(maxScore, score);
        }
        return dp[index] = maxScore;
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        // recursive
        System.out.println(f(stoneValue, 0));

        // memorization
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(memorize(stoneValue, dp, 0));

        // tabulation
        dp = new int[n + 1];
        for (int index = n - 1; index >= 0; --index) {
            dp[index] = Integer.MIN_VALUE;
            int stone = 0;
            for (int k = 0; k < 3 && index + k < n; ++k) {
                int i = index + k;
                stone += stoneValue[i];
                dp[index] = Math.max(dp[index], stone - dp[i + 1]);
            }
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public static void main(String[] args) {
        int[] stoneValue = {1, 2, 3, 7};
        System.out.println(new StoneGameIII().stoneGameIII(stoneValue));
    }
}
