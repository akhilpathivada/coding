/**
 * date 19/07/24 08:30
 *
 * @author akhil.p
 *
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
 *
 */
package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbersInAMatrix {

    public List<Integer> luckyNumbers (int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        final int[] minOfTheRow = new int[m];
        final int[] maxOfTheColumn = new int[n];
        Arrays.fill(maxOfTheColumn, Integer.MIN_VALUE);
        // find the minimum in each row
        for (int i = 0; i < m; ++i) {
            minOfTheRow[i] = Arrays.stream(matrix[i]).min().getAsInt();
        }
        // find the maximum in each column
        for (int j = 0; j < n; ++j) {
            for (int[] row : matrix) {
                maxOfTheColumn[j] = Math.max(maxOfTheColumn[j], row[j]);
            }
        }
        // find the lucky numbers
        final List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == minOfTheRow[i] && matrix[i][j] == maxOfTheColumn[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        return luckyNumbers;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(new LuckyNumbersInAMatrix().luckyNumbers(matrix));
    }
}
