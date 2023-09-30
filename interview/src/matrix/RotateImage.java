/**
 * https://leetcode.com/problems/rotate-image/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(1)
 * */
package matrix;

import java.util.Arrays;

public class RotateImage {

    private void rotate(int[][] matrix) {
        // since it is a n*n matrix, just need value of one dimension
        int n = matrix.length;
        // first : find the transpose of the matrix
        // means, first row becomes first column
        // second row becomes second column and so on....
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                // swap the cells
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // for the obtained transpose: reverse elements in each row
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 },
                           { 4, 5, 6 },
                           { 7, 8, 9 }
        };
        new RotateImage().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
