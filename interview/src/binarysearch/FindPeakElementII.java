/**
 * https://leetcode.com/problems/find-a-peak-element-ii/
 *
 * Time Complexity: O(m * log(n))
 * Space Complexity: O(1)
 * */
package binarysearch;

import java.util.Arrays;

public class FindPeakElementII {

    private int[] maxInColumn(int[][] mat, int j) {
        int max = -1;
        int[] coordinates = new int[2];
        for (int i = 0; i < mat.length; ++i) {
            if (mat[i][j] > max) {
                max = mat[i][j];
                coordinates[0] = i;
                coordinates[1] = j;
            }
        }
        return coordinates;
    }

    private int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] c = maxInColumn(mat, mid);
            int p = c[0];
            int q = c[1];
            boolean s1, s2, s3, s4;
            s1 = s2 = s3 = s4 = true;
            if (q - 1 >= 0) {
                s1 = mat[p][q] > mat[p][q - 1];
            }
            if (q + 1 < n) {
                s2 = mat[p][q] > mat[p][q + 1];
            }
            if (p - 1 >= 0) {
                s3 = mat[p][q] > mat[p - 1][q];
            }
            if (p + 1 < m) {
                s4 = mat[p][q] > mat[p + 1][q];
            }
            if (s1 && s2 && s3 && s4) {
                return c;
            }
            if ((q - 1) >= 0 && mat[p][q] < mat[p][q - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 4 }, { 3, 2 } };
        System.out.println(Arrays.toString(new FindPeakElementII().findPeakGrid(mat)));
    }
}
