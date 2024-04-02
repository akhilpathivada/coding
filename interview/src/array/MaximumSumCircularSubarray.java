/**
 * @author akhilpathivada
 * <p>
 * date : 02/04/24
 * time: 18:38
 *
 * https://leetcode.com/problems/maximum-sum-circular-subarray/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package array;

public class MaximumSumCircularSubarray {

    private int maxSubarraySumCircular(int[] nums) {
        // logic :: maxSubarraySumCircular = max(totalSum - minSum, maxSum)
        int totalSum = 0;
        int currMinSum = 0;
        int currMaxSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int num : nums) {
            totalSum += num;
            currMinSum = Math.min(currMinSum + num, num);
            currMaxSum = Math.max(currMaxSum + num, num);
            minSum = Math.min(currMinSum, minSum);
            maxSum = Math.max(currMaxSum, maxSum);
        }
        return maxSum > 0 ? Math.max(totalSum - minSum, maxSum) : maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { -3, -2, -3 };
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(nums));
    }
}
