/**
 * author: akhilpathivada
 * time: 14/06/24 09:19
 *
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/
 *
 */
package greedy;

import java.util.Arrays;
import java.util.Map;

public class MinimumIncrementToMakeArrayUnique {

    private int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int prev = -1, result = 0;
        for (int num : nums) {
            prev = Math.max(prev + 1, num);
            result += prev - num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 1, 7};
        System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(nums));
    }
}
