/**
 * author: akhilpathivada
 * time: 30/05/24 10:09
 */
package greedy;

public class MaximumAlternatingSubsequenceSum { // variant of Best Time to Buy and Sell Stock II

    private long maxAlternatingSum(int[] nums) {
        long sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum += Math.max(nums[i] - nums[i - 1], 0);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 1, 2, 4, 5};
        System.out.println(new MaximumAlternatingSubsequenceSum().maxAlternatingSum(nums));
    }
}
