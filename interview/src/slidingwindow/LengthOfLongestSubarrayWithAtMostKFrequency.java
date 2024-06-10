/**
 * author: akhilpathivada
 * time: 10/06/24 21:13
 *
 * https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
 *
 */
package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {

    private int maxSubarrayLength(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int right = 0; right < nums.length; ++right) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left++]) - 1);
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        System.out.println(new LengthOfLongestSubarrayWithAtMostKFrequency().maxSubarrayLength(nums, k));
    }
}
