/**
 * author: akhilpathivada
 * time: 01/06/24 06:02
 *
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 *
 */
package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    private boolean checkSubarraySum(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k;
            }
            if (map.containsKey(runningSum)) {
                if (i - map.get(runningSum) > 1) {
                    return true;
                }
            } else {
                map.put(runningSum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 6;
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(nums, k));
    }
}
