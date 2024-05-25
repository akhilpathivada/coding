/**
 * author: akhilpathivada
 * time: 25/05/24 16:05
 *
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 *
 */
package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        final Set<Integer> set = new HashSet<>();
        long sum = 0;
        long result = 0;
        int left = 0;
        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right];
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left++];
            }
            set.add(nums[right]);
            if (set.size() == k) {
                result = Math.max(result, sum);
                set.remove(nums[left]);
                sum -= nums[left++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(new MaximumSumOfDistinctSubarraysWithLengthK().maximumSubarraySum(nums, k));
    }
}
