/**
 * @author akhilpathivada
 * <p>
 * date : 09/01/24
 * time: 09:38
 *
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    private int subarraysDivByK(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0, result = 0;
        for (int num : nums) {
            prefixSum = (prefixSum + num % k + k) % k;
            result += map.getOrDefault(prefixSum, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(nums, k));
    }
}