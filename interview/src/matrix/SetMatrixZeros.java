/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(1)
 * */
package matrix;

import java.util.Arrays;

public class SetMatrixZeros {

    private void setZeroes(int[][] matrix) {
        // to track whether first row and first column have any '0's
        boolean firstRowContainsZero = false;
        boolean firstColumnContainsZero = false;

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                // the cell value is '0'
                if (matrix[i][j] == 0) {
                    // if first row have any '0'
                    if (i == 0) {
                        firstRowContainsZero = true;
                    }
                    // if first column have any '0'
                    if (j == 0) {
                        firstColumnContainsZero = true;
                    }
                    // in the future: if we want to decide to mark any cell as '0'
                    // or not, we track based on first element in the row and the column
                    // so, mark the first element in this row and
                    // first element in the column as '0'
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // iterate over the matrix except first row and first column
        // if a cell contains '0' and mark it's entire row & column with '0'
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                // check first element in this row / column is '0'
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // set the entire first row with '0'
        if (firstRowContainsZero) {
            Arrays.fill(matrix[0], 0);
        }
        // set the entire first column with '0'
        if (firstColumnContainsZero) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 2, 0 },
                           { 3, 4, 5, 2 },
                           { 1, 3, 1, 5 }
        };
        new SetMatrixZeros().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
