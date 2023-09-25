/**
 * Date 22/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 */
package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        // base case
        if (matrix.length == 0) {
            return result;
        }

        int rowBegin = 0; // stand at first row
        int rowEnd = matrix.length - 1; // stand at last row
        int columnBegin = 0; // stand at first column
        int columnEnd = matrix[0].length - 1; // stand at last column

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
            // Traverse Right
            for (int j = columnBegin; j <= columnEnd; ++j) {
                result.add(matrix[rowBegin][j]);
            }
            ++rowBegin;
            // Traverse Down
            for (int i = rowBegin; i <= rowEnd; ++i) {
                result.add(matrix[i][columnEnd]);
            }
            --columnEnd;
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = columnEnd; j >= columnBegin; --j) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            --rowEnd;
            if (columnBegin <= columnEnd) {
                // Traverse Up
                for (int i = rowEnd; i >= rowBegin; --i) {
                    result.add(matrix[i][columnBegin]);
                }
            }
            ++columnBegin;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 },
                           { 5, 6, 7, 8 },
                           { 9, 10, 11, 12 }
        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
