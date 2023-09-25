/**
 * https://leetcode.com/problems/plus-one/solutions/2706861/java-fastest-0ms-runtime-easy-and-elegant-solution/
 * */

package misc;

import java.util.Arrays;

public class PlusOne {

    private static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >=0; --i) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = { 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
