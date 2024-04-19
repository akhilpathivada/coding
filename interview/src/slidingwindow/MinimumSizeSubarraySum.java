/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package slidingwindow;

public class MinimumSizeSubarraySum {

        private int minSubArrayLength(int[] nums, int target) {
                if (nums == null || nums.length == 0) {
                        return 0;
                }
                int left = 0;
                int sum = 0;
                int minLength = Integer.MAX_VALUE;
                for (int right = 0; right < nums.length; ++right) {
                        sum += nums[right];
                        // slide the window
                        while (sum >= target) {
                                minLength = Math.min(minLength, right - left + 1);
                                sum -= nums[left++];
                        }
                }
                return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
        }

        public static void main(String[] args) {
            int[] nums = { 2, 3, 1, 2, 4, 3 };
            int target = 7;
            System.out.println(new MinimumSizeSubarraySum().minSubArrayLength(nums, target));
        }
}
