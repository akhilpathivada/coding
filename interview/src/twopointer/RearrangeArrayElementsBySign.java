/**
 * date 07/08/24 13:44
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 *
 */
package twopointer;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {

    private int[] rearrangeArray(int[] nums) {
        final int[] result = new int[nums.length];
        int positive = 0;
        int negative = 1;
        for (int num : nums) {
            if (num > 0) {
                result[positive] = num;
                positive += 2;
            } else {
                result[negative] = num;
                negative += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(new RearrangeArrayElementsBySign().rearrangeArray(nums)));
    }
}
