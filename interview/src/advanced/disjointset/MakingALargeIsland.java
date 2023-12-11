/**
 * https://leetcode.com/problems/making-a-large-island/
 * https://www.codingninjas.com/studio/problems/making-the-largest-island_1381282?leftPanelTabValue=PROBLEM
 * https://www.geeksforgeeks.org/problems/maximum-connected-group/1
 *
 * Time Complexity: O(m * n) * O(Q * 4α) ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.
 * Space Complexity: O(Q) + O(N * M) + O(N * M), where Q = no. of queries, N = total no. of rows, M = total no. of columns.
 * */
package advanced.disjointset;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {

    private boolean isValidNeighbour(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        DisjointSet disjointSet = new DisjointSet(m * n);
        // the four directions we can check
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // step-1: create a disjoint set from the grid
        // where all the nodes of an island are under same set
        for (int row = 0; row < m; ++row) {
            for (int column = 0; column < n; ++column) {
                if (grid[row][column] == 0) {
                    continue;
                }
                for (int[] direction : directions) {
                    int x = row + direction[0];
                    int y = column + direction[1];
                    if (isValidNeighbour(x, y, n, m) && grid[x][y] == 1) {
                        int currentNodeNumber = row * m + column;
                        int adjacentNodeNumber = x * m + y;
                        disjointSet.unionBySize(currentNodeNumber, adjacentNodeNumber);
                    }
                }
            }
        }
        // step-2: take every '0' and try to convert to '1'
        for (int row = 0; row < m; ++row) {
            for (int column = 0; column < n; ++column) {
                if (grid[row][column] == 1) {
                    continue;
                }
                Set<Integer> componentsSet = new HashSet<>();
                for (int[] direction : directions) {
                    int x = row + direction[0];
                    int y = column + direction[1];
                    if (isValidNeighbour(x, y, n, m) && grid[x][y] == 1) {
                        // find ultimate parent of adjacentNodeNumber
                        componentsSet.add(disjointSet.findUltimateParent(x * m + y));
                    }
                }
                int totalSizeOfAllNeighbourComponents = 0;
                for (Integer component : componentsSet) {
                    totalSizeOfAllNeighbourComponents += disjointSet.size[component];
                }
                maxArea = Math.max(maxArea, 1 + totalSizeOfAllNeighbourComponents);
            }
        }
        // edge case: where the grid contains all '1's
        for (int node = 0; node < m * n; ++node) {
            maxArea = Math.max(maxArea, disjointSet.size[disjointSet.findUltimateParent(node)]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1 }, { 1, 0 } };
        System.out.println(new MakingALargeIsland().largestIsland(grid));
    }
}
