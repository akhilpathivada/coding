/**
 * author: akhilpathivada
 * time: 25/09/24 07:14
 *
 * https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/
 *
 */
package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheLengthOfTheLongestCommonPrefix {

    private int getDigitsCount(int num) {
        return (int) Math.log10(num) + 1;
    }

    private int longestCommonPrefix(int[] arr1, int[] arr2) {
        final Set<Integer> prefixSet = new HashSet<>();
        int result = 0;
        for (int num : arr1) {
            for (int value = num; value > 0; value /= 10) {
                prefixSet.add(value);
            }
        }
        for (int num : arr2) {
            for (int value = num; value > 0; value /= 10) {
                if (prefixSet.contains(value)) {
                    result = Math.max(result, getDigitsCount(value));
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        System.out.println(new FindTheLengthOfTheLongestCommonPrefix().longestCommonPrefix(arr1, arr2));
    }
}
