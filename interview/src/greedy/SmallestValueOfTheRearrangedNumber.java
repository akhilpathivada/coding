/**
 * date 22/07/24 13:22
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/smallest-value-of-the-rearranged-number/description/
 *
 */
package greedy;

import java.util.Arrays;

public class SmallestValueOfTheRearrangedNumber {

    private long smallestNumber(long num) {
        final char[] arr = String.valueOf(num < 0 ? -1 * num : num).toCharArray();
        final StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        if (num < 0) {
            sb.append(String.valueOf(arr)).append("-").reverse();
        } else {
            for (int i = 0; i < arr.length; ++i) { // we need to find out the first non-leading zero then swap with first zero
                if (arr[i] != '0') {
                    char temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
            sb.append(String.valueOf(arr));
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        long num = 310;
        System.out.println(new SmallestValueOfTheRearrangedNumber().smallestNumber(num));
    }
}
