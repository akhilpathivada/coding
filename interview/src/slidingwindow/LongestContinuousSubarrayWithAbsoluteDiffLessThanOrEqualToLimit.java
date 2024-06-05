/**
 * author: akhilpathivada
 * time: 04/06/24 23:21
 *
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
 *
 */
package slidingwindow;

import java.util.TreeMap;
import java.util.TreeSet;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    private int longestSubarray(int[] nums, int limit) {
        final TreeMap<Integer, Integer> orderedMap = new TreeMap<>();
        int left = 0;
        int longest = 0;
        for (int right = 0; right < nums.length; ++right) {
            orderedMap.put(nums[right], orderedMap.getOrDefault(nums[right], 0) + 1);
            while (orderedMap.lastKey() - orderedMap.firstKey() > limit) {
                orderedMap.put(nums[left], orderedMap.get(nums[left]) - 1);
                if (orderedMap.get(nums[left]) == 0) {
                    orderedMap.remove(nums[left]);
                }
                ++left;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0;
        System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit()
                .longestSubarray(nums, limit));
    }
}
