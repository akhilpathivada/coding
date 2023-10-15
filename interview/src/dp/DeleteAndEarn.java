/**
 * https://leetcode.com/problems/delete-and-earn/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * */
package dp;

public class DeleteAndEarn {

    private int deleteAndEarn(int[] nums) {
        int[] points = new int[10001];
        for (int n : nums) {
            points[n] += n;
        }
        int[] dp = new int[10003];
        for (int i = 10000; i >= 0; --i) {
            dp[i] = Math.max(points[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 3, 4 };
        System.out.println(new DeleteAndEarn().deleteAndEarn(nums));
    }
}
