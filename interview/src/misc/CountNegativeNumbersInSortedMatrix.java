/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 * */
package misc;

public class CountNegativeNumbersInSortedMatrix {

    private int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int r = m - 1;
        int c = 0;
        int count = 0;
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                count += n - c;
                --r;
            } else {
                ++c;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = { { 4, 3, 2, -1 },
                         { 3, 2, 1, -1 },
                         { 1, 1, -1, -2 },
                         { -1, -1, -2, -3 }
        };
        System.out.println(new CountNegativeNumbersInSortedMatrix().countNegatives(grid));
    }
}
