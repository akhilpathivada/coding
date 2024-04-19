/**
 * https://www.codingninjas.com/studio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494
 *
 * Time Complexity: O(n * sum)
 * Space Complexity: O(n * sum)
 * */
package dp.subsetsum;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {

    private boolean[][] getSubsetSums(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i <= target; ++i) {
            dp[0][i] = (nums[0] == i);
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= target; ++j) {
                boolean taken = false;
                if (nums[i] <= j) {
                    taken = dp[i - 1][j - nums[i]];
                }
                boolean notTaken = dp[i - 1][j];
                dp[i][j] = taken || notTaken;
            }
        }
        return dp;
    }

    private int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // get the tabulation sum
        boolean[][] dp = getSubsetSums(nums, sum);
        // now check for which of the sub-sums we can find the subset sum i.e., in last row
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sum; ++i) {
            if (dp[n - 1][i]) {
                minDiff = Math.min(minDiff, Math.abs(i - (sum - i)));
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 9, 7, 3 };
        System.out.println(new PartitionArrayIntoTwoArraysToMinimizeSumDifference().minimumDifference(nums));
    }
}
