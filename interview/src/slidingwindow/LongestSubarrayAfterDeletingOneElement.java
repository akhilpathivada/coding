/**
 * Date 13/04/24
 * Time 11:56
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 *
 */
package slidingwindow;

public class LongestSubarrayAfterDeletingOneElement {

    private int longestSubarray(int[] nums) {
        int maxLength = 0;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; ++right) {
            count += nums[right] == 0 ? 1 : 0;
            while (count > 1) {
                count -= nums[left++] == 0 ? 1 : 0;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(new LongestSubarrayAfterDeletingOneElement().longestSubarray(nums));
    }
}
