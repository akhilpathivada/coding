/**
 * Date 13/04/24
 * Time 11:45
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package slidingwindow;

public class MaxConsecutiveOnesIII {

    private int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxOnes = 0;
        int count = 0;
        for (int right = 0; right < nums.length; ++right) {
            count += (nums[right] == 0) ? 1 : 0;
            while (count > k) {
                count -= (nums[left++] == 0) ? 1 : 0;
            }
            maxOnes = Math.max(maxOnes, right - left + 1);
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(nums, k));
    }
}
