/**
 * Date 05/04/2024
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/largest-divisible-subset/
 * https://www.naukri.com/code360/problems/divisible-set_3754960?leftPanelTabValue=PROBLEM
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(N)
 * */
package dp.lis;

import java.util.*;

public class LargestDivisibleSubset {

    private boolean isDivisible(int a, int b) {
        return a % b == 0 || b % a == 0;
    }

    private List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // store (num, divisible set of num)
        Map<Integer, List<Integer>> dp = new HashMap<>();
        List<Integer> largestSubset = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> currentDivisibleSubset = Collections.singletonList(nums[i]);
            for (int j = i - 1; j >= 0; --j) {
                if (isDivisible(nums[i], nums[j])) {
                    if (dp.get(nums[j]).size() + 1 > currentDivisibleSubset.size()) {
                        currentDivisibleSubset = new ArrayList<>(dp.get(nums[j]));
                        currentDivisibleSubset.add(nums[i]);
                    }
                }
            }
            // update the set
            dp.put(nums[i], currentDivisibleSubset);
            if (currentDivisibleSubset.size() > largestSubset.size()) {
                largestSubset = new ArrayList<>(currentDivisibleSubset);
            }
        }
        return largestSubset;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(nums));
    }
}
