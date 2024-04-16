package bfs.multisource;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 16/04/24
 * Time 11:44
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/rotting-oranges/description/
 *
 */
public class RottingOranges {

    private static final class Cell {

        private final int row;

        private final int col;

        private Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int numberOfFreshOranges = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j));
                } else if (grid[i][j] == 1) {
                    ++numberOfFreshOranges;
                }
            }
        }
        if (numberOfFreshOranges == 0) {
            return 0;
        }
        // the four directions
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // no. of minutes
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Cell current = queue.poll();
                int row = current.row;
                int col = current.col;
                for (int[] direction : directions) {
                    int nrow = row + direction[0];
                    int ncol = col + direction[1];
                    if (nrow < 0 || nrow == m || ncol < 0 || ncol == n || grid[nrow][ncol] == 0 || grid[nrow][ncol] == 2) {
                        continue;
                    }
                    // rot the fresh orange
                    grid[nrow][ncol] = 2;
                    queue.add(new Cell(nrow, ncol));
                    --numberOfFreshOranges;
                }
            }
            ++minutes;
        }
        return numberOfFreshOranges > 0 ? -1 : minutes - 1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(new RottingOranges().orangesRotting(grid));
    }
}
