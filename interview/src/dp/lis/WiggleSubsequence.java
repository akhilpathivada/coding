/**
 * author: akhilpathivada
 * time: 30/05/24 08:29
 *
 * https://leetcode.com/problems/wiggle-subsequence/description/
 *
 */
package dp.lis;

public class WiggleSubsequence {

    private int wiggleMaxLength(int[] nums) {
        final int n = nums.length;
        final int[] up = new int[n];
        final int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
    }
}
