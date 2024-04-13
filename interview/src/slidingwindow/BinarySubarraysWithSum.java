/**
 * Date 13/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/binary-subarrays-with-sum/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package slidingwindow;

public class BinarySubarraysWithSum {

    private int numSubarraysWithSumUtil(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                ++left;
            }
            count += right - left + 1;
            ++right;
        }
        return count;
    }

    private int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumUtil(nums, goal) - numSubarraysWithSumUtil(nums, goal - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSum(nums, goal));
    }
}
