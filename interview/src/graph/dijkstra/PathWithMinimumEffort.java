/**
 * @author akhilpathivada
 * <p>
 * date : 31/03/24
 * time: 07:51
 *
 * https://leetcode.com/problems/path-with-minimum-effort/description/
 *
 * Time Complexity: O(m * n * 4 * (log mn))
 * Space Complexity: O(mn)
 */
package graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    private static final class Tuple {

        private final int diff;

        private final int row;

        private final int col;

        private Tuple(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }

    private int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // stores the distance of the cell from the source
        int[][] dist = new int[m][n];
        // heap node stores (path diff so far, row, column)
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((Tuple1, Tuple2) -> Integer.compare(Tuple1.diff, Tuple2.diff));
        // the four directions
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // fill distances with INF default
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        minHeap.add(new Tuple(0, 0, 0));
        while (!minHeap.isEmpty()) {
            int effortSoFar = minHeap.peek().diff;
            int row = minHeap.peek().row;
            int col = minHeap.peek().col;
            minHeap.remove();
            // at destination
            if (row == m - 1 && col == n - 1) {
                return effortSoFar;
            }
            for (int[] direction : directions) {
                int nrow = row + direction[0];
                int ncol = col + direction[1];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                    int newEffort = Math.max(effortSoFar, Math.abs(heights[row][col] - heights[nrow][ncol]));
                    if (newEffort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newEffort;
                        minHeap.add(new Tuple(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
        System.out.println(new PathWithMinimumEffort().minimumEffortPath(heights));
    }
}
