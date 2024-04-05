/**
 * https://leetcode.com/problems/delete-and-earn/description/
 *
 * Time Complexity: O(n * log n)
 * Space Complexity: O(n)
 * */
package dp;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteAndEarn {

    // store frequencies
    private final Map<Integer, Integer> frequencyMap = new HashMap<>();

    private int deleteAndEarn_2(int[] nums) {
        int[] points = new int[10001];
        for (int n : nums) {
            points[n] += n;
        }
        int[] dp = new int[10003];
        for (int i = 10000; i >= 0; --i) {
            dp[i] = Math.max(points[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    private void insertIntoMap(int[] nums) {
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
    }

    private int getCount(int num) {
        return frequencyMap.get(num);
    }

    private int deleteAndEarn(int[] nums) {
        insertIntoMap(nums);
        // convert to hash set and convert back to int array
        nums = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet())
                .stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
        int n = nums.length;
        int[] dp = new int[n];
        // cache the earnings for element at index-0
        dp[0] = nums[0] * getCount(nums[0]);
        if (n == 1) {
            return dp[0];
        }
        // cache the earnings for element at index-1
        int currentEarn = nums[1] * getCount(nums[1]);
        dp[1] = (nums[0] + 1 == nums[1]) ? Math.max(dp[0], currentEarn) : dp[0] + currentEarn;
        for (int i = 2; i < n; ++i) {
            currentEarn = nums[i] * getCount(nums[i]);
            // if preceding element is num-1
            if (nums[i - 1] + 1 == nums[i]) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + currentEarn);
            } else {
                dp[i] = dp[i - 1] + currentEarn;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 3, 4 };
        System.out.println(new DeleteAndEarn().deleteAndEarn(nums));
    }
}
