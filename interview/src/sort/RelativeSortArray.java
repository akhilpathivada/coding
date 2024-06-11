/**
 * author: akhilpathivada
 * time: 11/06/24 08:14
 *
 * https://leetcode.com/problems/relative-sort-array/description/
 *
 */
package sort;

import java.util.Arrays;

public class RelativeSortArray {

    private int[] relativeSortArray(int[] arr1, int[] arr2) {
        final int[] count = new int[1001];
        for (int a : arr1) {
            count[a]++;
        }
        int i = 0;
        for (int a : arr2) {
            while (count[a]-- > 0) {
                arr1[i++] = a;
            }
        }
        for (int j = 0; j < count.length; ++j) {
            while (count[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(new RelativeSortArray().relativeSortArray(arr1, arr2)));
    }
}
