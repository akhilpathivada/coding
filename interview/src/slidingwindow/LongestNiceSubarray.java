/**
 * author: akhilpathivada
 * time: 19/06/24 09:50
 *
 * https://leetcode.com/problems/longest-nice-subarray/description/
 *
 */
package slidingwindow;

public class LongestNiceSubarray {

    private int longestNiceSubarray(int[] nums) {
        int AND = 0;
        int left = 0;
        int result = 0;
        for (int right = 0; right < nums.length; ++right) {
            while ((AND & nums[right]) > 0) {
                AND ^= nums[left++];
            }
            AND |= nums[right];
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 48, 10};
        System.out.println(new LongestNiceSubarray().longestNiceSubarray(nums));
    }
}
