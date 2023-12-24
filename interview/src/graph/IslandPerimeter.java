/**
 * @author akhilpathivada
 * <p>
 * date : 24/12/23
 * time: 18:17
 *
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */
package graph;

public class IslandPerimeter {

    private int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int perimeter = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    // current cell has neighbouring land
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }
}
