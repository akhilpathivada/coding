/**
 * https://leetcode.com/problems/two-sum/
 *
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * */
package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // approach-1
    private int[] twoSum(int[] nums, int target) {
        final int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // approach-2
    private int[] twoSum_2(int[] nums, int target) {
        final int n = nums.length;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }
}
