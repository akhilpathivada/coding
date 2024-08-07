/**
 * date 07/08/24 15:40
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/longest-mountain-in-array/description/
 *
 */
package dp.lis;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestMountainInArray {

    private int longestMountain(int[] arr) {
        final int n = arr.length;
        final int[] lis = new int[n];
        final int[] lds = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        for (int i = 1; i < n; ++i) {
            if (arr[i] > arr[i - 1]) {
                lis[i] = lis[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                lds[i] = lds[i + 1] + 1;
            }
        }
        return IntStream.range(0, n).filter(i -> lis[i] > 1 && lds[i] > 1).map(i -> lis[i] + lds[i] - 1).max().orElse(0);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(new LongestMountainInArray().longestMountain(arr));
    }
}
