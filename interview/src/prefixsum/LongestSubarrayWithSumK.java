package prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 16/04/24
 * Time 15:46
 *
 * @author akhilpathivada
 *
 * https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_6682399?leftPanelTabValue=PROBLEM
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LongestSubarrayWithSumK {


    private int longestSubarrayWithSumK(int[] arr, long k) {
        int prefixSum = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < arr.length; ++i) {
            prefixSum += arr[i];
            int key = prefixSum - (int) k;
            if (map.containsKey(key)) {
                result = Math.max(result, i - map.get(key));
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        long k = 3;
        System.out.println(new LongestSubarrayWithSumK().longestSubarrayWithSumK(arr, k));
    }
}
