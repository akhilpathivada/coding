/**
 * @author akhilpathivada
 * <p>
 * date : 19/03/24
 * time: 08:46
 *
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/description/
 *
 * <p>
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package hashing;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {

    private static final int mod = 1000000007;

    private int rev(int n) {
        int rev = 0;
        while (n > 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        return rev;
    }

    private int countNicePairs(int[] nums) {
        int n = nums.length;
        // logic:: The real Equation: nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        // The simple and more intuitive form of above equation: (nums[i] - rev(nums[i])) == (nums[j] - rev(nums[j]))
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int countOfNicePairs = 0;
        for (int num : nums) {
            // diff = nums[i] - rev(nums[i])
            int diff = num - rev(num);
            countOfNicePairs = (countOfNicePairs + frequencyMap.getOrDefault(diff, 0)) % mod;
            frequencyMap.put(diff, frequencyMap.getOrDefault(diff, 0) + 1);
        }
        return countOfNicePairs;
    }

    public static void main(String[] args) {
        int[] nums = { 42, 11, 1, 97 };
        System.out.println(new CountNicePairs().countNicePairs(nums));
    }
}
