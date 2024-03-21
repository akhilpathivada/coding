/**
 * @author akhilpathivada
 * <p>
 * date : 19/03/24
 * time: 06:23
 * <p>
 * https://leetcode.com/problems/count-number-of-bad-pairs/
 * <p>
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package hashing;

import java.util.HashMap;
import java.util.Map;

public class CountBadPairs {

    private long countBadPairs(int[] nums) {
        int n = nums.length;
        // logic:: The real Equation: ( j - i ) != ( A[j] - A[i] )
        // The simple and more intuitive form of above equation: ( j - A[j] ) != ( i - A[i] )
        Map<Integer, Integer> map = new HashMap<>();
        long countOfBadPairs = 0;
        for (int i = 0; i < n; ++i) {
            int prev = map.getOrDefault(i - nums[i], 0);
            countOfBadPairs += i - prev;
            map.put(i - nums[i], prev + 1);
        }
        return countOfBadPairs;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 3, 3 };
        System.out.println(new CountBadPairs().countBadPairs(nums));
    }
}
