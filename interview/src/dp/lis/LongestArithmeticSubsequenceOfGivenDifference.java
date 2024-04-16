package dp.lis;

import java.util.HashMap;
import java.util.Map;

/**
 * Date 16/04/24
 * Time 06:27
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LongestArithmeticSubsequenceOfGivenDifference {

    private int longestSubsequence(int[] arr, int difference) {
        int result = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num - difference, 0) + 1);
            result = Math.max(result, map.get(num));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        int difference = -2;
        System.out.println(new LongestArithmeticSubsequenceOfGivenDifference().longestSubsequence(arr, difference));
    }
}
