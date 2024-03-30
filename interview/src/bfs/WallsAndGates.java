/**
 * @author akhilpathivada
 * <p>
 * date : 30/03/24
 * time: 07:47
 *
 * https://www.naukri.com/code360/problems/walls-and-gates_1092887
 *
 * Time Complexity: O(m * n * 4)
 * Space Complexity: O(m * n)
 */
package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    private static final int INF = 2147483647;

    private static class Pair {

        private final int first;

        private final int second;

        private Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int[][] wallsAndGates(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();
        // take only the Gates and add it to the queue
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));
                }
            }
        }
        // the four directions we can check
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // start from distance 0
        int distance = 0;
        // perform bfs from the gates
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair cell = queue.poll();
                int row = cell.first;
                int col = cell.second;
                grid[row][col] = distance;
                for (int[] direction : directions) {
                    int nrow = row + direction[0];
                    int ncol = col + direction[1];
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] != -1 && !visited[nrow][ncol]) {
                        // mark the neighbor cell as reachable from a boundary cell
                        visited[nrow][ncol] = true;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }
            ++distance;
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = { { INF, -1, 0, INF }, { INF, INF, INF, -1 }, { INF, -1, INF, -1 }, { 0, -1, INF, INF } };
        System.out.println(Arrays.deepToString(new WallsAndGates().wallsAndGates(grid)));
    }
}
