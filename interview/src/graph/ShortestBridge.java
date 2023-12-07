/**
 *
 * https://leetcode.com/problems/shortest-bridge/description/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N ^ 2)
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    private void dfs(int[][] grid, Queue<int[]> queue, int n, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == 0 || grid[i][j] == 2) {
            return;
        }
        queue.offer(new int[] { i, j });
        // mark the visited elements as 2
        grid[i][j] = 2;
        dfs(grid, queue, n, i + 1, j);
        dfs(grid, queue, n, i, j + 1);
        dfs(grid, queue, n, i - 1, j);
        dfs(grid, queue, n, i, j - 1);
    }

    private int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        // track the first island is found or not
        boolean found = false;
        // search for the first island, once it found :
        // store the co-ordinates of all cells of firstIsland in a Queue through DFS traversal
        for (int i = 0; i < n && !found; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(grid, queue, n, i, j);
                    found = true;
                    break;
                }
            }
        }
        // the four directions we can traverse
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int shortestDistance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) { // we found the second island
                        return shortestDistance;
                    }
                    queue.offer(new int[] { x, y });
                    grid[x][y] = 2;
                }
            }
            ++shortestDistance;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
        System.out.println(new ShortestBridge().shortestBridge(grid));
    }
}
