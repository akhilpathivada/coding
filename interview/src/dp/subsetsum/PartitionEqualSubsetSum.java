/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * https://www.codingninjas.com/studio/problems/partition-equal-subset-sum_892980
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 * */
package dp.subsetsum;

public class PartitionEqualSubsetSum {

    private boolean isSubsetSum(int[] set, int n, int sum) {
        boolean table[][] = new boolean[n + 1][sum + 1];
        // If sum is 0, then answer is true
        for (int i = 0; i <= n; ++i) {
            table[i][0] = true;
        }
        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; ++i) {
            table[0][i] = false;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (set[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] =  table[i - 1][j - set[i - 1]] || table[i - 1][j];
                }
            }
        }
        return table[n][sum];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return isSubsetSum(nums, nums.length, sum / 2);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }
}
