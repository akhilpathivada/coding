/**
 * @author akhilpathivada
 * <p>
 * date : 23/12/23
 * time: 07:33
 *
 * https://leetcode.com/problems/count-sub-islands/description/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 */
package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountSubIslands {

    private void dfs(int[][] grid, int i, int j, int m, int n, int baseRow, int baseColumn, List<String> coordinates) {
        // base case
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) {
            return;
        }
        // mark the island as visited
        grid[i][j] = 0;
        // store the coordinate
        coordinates.add(baseRow - i + "," + (baseColumn - j));
        // recur on its neighbours
        dfs(grid, i + 1, j, m, n, baseRow, baseColumn, coordinates);
        dfs(grid, i - 1, j, m, n, baseRow, baseColumn, coordinates);
        dfs(grid, i, j + 1, m, n, baseRow, baseColumn, coordinates);
        dfs(grid, i, j - 1, m, n, baseRow, baseColumn, coordinates);
    }


    private int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        if (m == 0) {
            return 0;
        }
        int n = grid1[0].length;
        List<Set<String>> islandsSetOfGrid1 = new ArrayList<>();
//        List<String> islandsOfGrid2 = new ArrayList<>();
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                // island found
//                if (grid1[i][j] == 1) {
//                    List<String> coordinates = new ArrayList<>();
//                    dfs(grid, i, j, m, n, i, j, coordinates);
//                    set.add(coordinates);
//                }
//            }
//        }
//        for (Set<String> island : islandsSetOfGrid1) {
//            if (island.contains())
//        }
//        return set.size();
        return 1;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                { 1, 1, 1, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 }
        };
        int[][] grid2 = {
                { 1, 1, 1, 0, 0 },
                { 0, 0, 1, 1, 1 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 }
        };
    }
}
