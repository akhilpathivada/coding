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

public class CountSubIslands {

    private int flag;

    private void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // base case
        if (i < 0 || j < 0 || i == grid1.length || j == grid1[0].length || grid2[i][j] == 0) {
            return;
        }
        if (grid1[i][j] == 0) {
            flag = 0;
        }
        // mark the island as visited
        grid2[i][j] = 0;
        // recur on its neighbours
        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i, j + 1);
        dfs(grid1, grid2, i, j - 1);
    }

    private int countSubIslands(int[][] grid1, int[][] grid2) {
        int countOfSubIslands = 0;
        for (int i = 0; i < grid1.length; ++i) {
            for (int j = 0; j < grid1[0].length; ++j) {
                if (grid2[i][j] == 1) {
                    flag = 1;
                    dfs(grid1, grid2, i, j);
                    countOfSubIslands += flag;
                }
            }
        }
        return countOfSubIslands;
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
        System.out.println(new CountSubIslands().countSubIslands(grid1, grid2));
    }
}
