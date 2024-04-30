/**
 * author: akhilpathivada
 * time: 30/04/24 20:57
 *
 * https://leetcode.com/problems/maximum-erasure-value/description/
 *
 */
package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    private int maximumUniqueSubarray(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        int result = Integer.MIN_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; ++right) {
            while (set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left++]);
            }
            sum += nums[right];
            set.add(nums[right]);
            result = Math.max(result, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        System.out.println(new MaximumErasureValue().maximumUniqueSubarray(nums));
    }
}
