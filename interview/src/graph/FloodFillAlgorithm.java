/**
 * @author akhilpathivada
 * <p>
 * date : 24/12/23
 * time: 07:05
 *
 * https://leetcode.com/problems/flood-fill/description/
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
package graph;

import java.util.Arrays;

public class FloodFillAlgorithm {

    private void dfs(int[][] image, int row, int col, int m, int n, int initialColor, int newColor) {
        // base case
        if (row < 0 || col < 0 || row >= m || col >= n || image[row][col] != initialColor
                || image[row][col] == newColor) {
            return;
        }
        // recolor this cell
        image[row][col] = newColor;
        // recur on its neighbours
        dfs(image, row + 1, col, m, n, initialColor, newColor);
        dfs(image, row - 1, col, m, n, initialColor, newColor);
        dfs(image, row, col + 1, m, n, initialColor, newColor);
        dfs(image, row, col - 1, m, n, initialColor, newColor);
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image.length, image[0].length, image[sr][sc], color);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        System.out.println(Arrays.deepToString(new FloodFillAlgorithm().floodFill(image, sr, sc, color)));
    }
}
