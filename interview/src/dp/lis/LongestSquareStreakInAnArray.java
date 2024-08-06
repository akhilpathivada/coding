/**
 * date 06/08/24 17:29
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/longest-square-streak-in-an-array/description/
 *
 */
package dp.lis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSquareStreakInAnArray {

    private int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        final Map<Integer, Integer> map = new HashMap<>(); // holds <num, freq>
        int result = -1;
        for (int num : nums) {
            int squareRoot = (int) Math.sqrt(num);
            if (squareRoot * squareRoot == num && map.containsKey(squareRoot)) {
                map.put(num, map.get(squareRoot) + 1);
                result = Math.max(result, map.get(num));
            } else {
                map.put(num, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 16, 8, 2};
        System.out.println(new LongestSquareStreakInAnArray().longestSquareStreak(nums));
    }
}
