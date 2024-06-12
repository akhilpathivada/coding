/**
 * author: akhilpathivada
 * time: 12/06/24 09:42
 *
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
 *
 */
package hashing;

import java.util.*;

public class FindThePrefixCommonArrayOfTwoArrays {

    private int[] findThePrefixCommonArray(int[] A, int[] B) {
        final int n = A.length;
        final int[] count = new int[n + 1];
        final int[] result = new int[n];
        int matches = 0;
        for (int i = 0; i < n; ++i) {
            matches += ++count[A[i]] == 2 ? 1 : 0;
            matches += ++count[B[i]] == 2 ? 1 : 0;
            result[i] = matches;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        System.out.println(Arrays.toString(new FindThePrefixCommonArrayOfTwoArrays().findThePrefixCommonArray(A, B)));
    }
}
