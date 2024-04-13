/**
 * Date 13/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/subarrays-with-k-different-integers/description/
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(k)
 */
package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    private int subarraysWithKDistinctUtil(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                int num = nums[left];
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
                ++left;
            }
            count += right - left + 1;
            ++right;
        }
        return count;
    }

    private int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinctUtil(nums, k) - subarraysWithKDistinctUtil(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(new SubarraysWithKDifferentIntegers().subarraysWithKDistinct(nums, k));
    }
}
