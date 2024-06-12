/**
 * author: akhilpathivada
 * time: 12/06/24 12:32
 *
 * https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/
 *
 */
package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarraysInAnArray {

    private int countCompleteSubarrays(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            set.add(num);
        }
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; ++right) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() == set.size()) {
                count += nums.length - right;
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                ++left;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 2};
        System.out.println(new CountCompleteSubarraysInAnArray().countCompleteSubarrays(nums));
    }
}
