/**
 * @author akhilpathivada
 * <p>
 * date : 29/03/24
 * time: 06:22
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    private void dfs(int row, int col, int[][] heights, boolean[][] visited, int prevHeight) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col]
                || heights[row][col] < prevHeight) {
            return;
        }
        visited[row][col] = true;
        dfs(row + 1, col, heights, visited, heights[row][col]);
        dfs(row - 1, col, heights, visited, heights[row][col]);
        dfs(row, col + 1, heights, visited, heights[row][col]);
        dfs(row, col - 1, heights, visited, heights[row][col]);
    }

    private List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n]; // cell can flow into pacific ocean
        boolean[][] atlantic = new boolean[m][n]; // cell can flow into atlantic ocean
        // start dfs with first column and see cells can flow into the oceans
        for (int col = 0; col < n; ++col) {
            dfs(0, col, heights, pacific, Integer.MIN_VALUE); // move down to find cells can be flown in to pacific
            dfs(m - 1, col, heights, atlantic, Integer.MIN_VALUE); // move up to find cells can be flown in to atlantic
        }
        // start dfs with first row and see cells can flow into the oceans
        for (int row = 0; row < m; ++row) {
            dfs(row, 0, heights, pacific, Integer.MIN_VALUE); // move right to find cells can be flown in to pacific
            dfs(row, n - 1, heights, atlantic, Integer.MIN_VALUE); // move left to find cells can be flown in to atlantic
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(new ArrayList<>(Arrays.asList(row, col)));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2, 3, 5 },
                            { 3, 2, 3, 4, 4 },
                            { 2, 4, 5, 3, 1 },
                            { 6, 7, 1, 4, 5 },
                            { 5, 1, 1, 2, 4 }
        };
        System.out.println(new PacificAtlanticWaterFlow().pacificAtlantic(heights));
    }
}
