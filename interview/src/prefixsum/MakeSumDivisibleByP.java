/**
 * author: akhilpathivada
 * time: 03/10/24 21:03
 *
 * https://leetcode.com/problems/make-sum-divisible-by-p/description/
 *
 */
package prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MakeSumDivisibleByP {

    public int minSubarray(int[] nums, int p) {
        final int n = nums.length;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        final int remainder = (int) (totalSum % p);
        if (remainder == 0) { // no need to remove any subarray
            return 0;
        }
        final Map<Integer, Integer> prefixModMap = new HashMap<>();
        long prefixSum = 0;
        int minLength = n;
        prefixModMap.put(0, -1);
        for (int i = 0; i < n; ++i) {
            prefixSum += nums[i];
            int currentMod = (int) (prefixSum % p);
            int requiredMod = (currentMod - remainder + p) % p;
            if (prefixModMap.containsKey(requiredMod)) {
                minLength = Math.min(minLength, i - prefixModMap.get(requiredMod));
            }
            prefixModMap.put(currentMod, i);
        }
        return Optional.of(minLength).filter(length -> length != n).orElse(-1);
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 5, 2};
        int p = 9;
        System.out.println(new MakeSumDivisibleByP().minSubarray(nums, p));
    }
}
