/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/description/
 * https://www.codingninjas.com/studio/problems/minimum-elements_3843091
 *
 * Time Complexity : O(N * K)
 * Space Complexity : O(N)
 * */
package dp.partition;

public class PartitionArrayForMaximumSum {

    private int f(int[] arr, int k, int n, int i) {
        // base case
        if (i == n) {
            return 0;
        }
        int len = 0;
        int maxElement = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int j = i; j < i + k && j < n; ++j) {
            ++len;
            maxElement = Math.max(maxElement, arr[j]);
            int sum = (len * maxElement) + f(arr, k, n, j + 1);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    private int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // from recursion
        int recursion = f(arr, k, n, 0);
        // from tabulation
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int len = 0;
            int maxElement = Integer.MIN_VALUE;
            int maxSum = Integer.MIN_VALUE;
            for (int j = i; j < i + k && j < n; ++j) {
                ++len;
                maxElement = Math.max(maxElement, arr[j]);
                int sum = (len * maxElement) + dp[j + 1];
                maxSum = Math.max(maxSum, sum);
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(arr, k));
    }
}
