package bfs.multisource;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 25/04/24
 * Time 10:25
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/as-far-from-land-as-possible/description/
 *
 */
public class AsFarFromLandAsPossible {

    private int maxDistance(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) { // land
                    grid[i][j] = 0; // make the land 0 because we will sum it with child
                    queue.add(new int[]{i, j});
                } else {
                    grid[i][j] = -1;
                }
            }
        }
        // the four directions we can traverse
        final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            queue.remove();
            for (int[] direction : directions) {
                int nrow = row + direction[0];
                int ncol = col + direction[1];
                if (nrow < 0 || nrow == m || ncol < 0 || ncol == n || grid[nrow][ncol] > -1) {
                    continue;
                }
                grid[nrow][ncol] = grid[row][col] + 1; // mark as visited
                queue.add(new int[]{nrow, ncol});
                result = Math.max(result, grid[nrow][ncol]);
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(new AsFarFromLandAsPossible().maxDistance(grid));
    }
}
