/**
 * @author akhilpathivada
 * <p>
 * date : 28/12/23
 * time: 15:49
 *
 * https://leetcode.com/problems/01-matrix/
 * https://www.codingninjas.com/studio/problems/distance-of-nearest-cell-having-1-in-a-binary-matrix_1169913
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 *
 */
package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    private class Node {

        private final int first; // row

        private final int second; // column

        private final int third; // distance

        private Node(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    private boolean isValidNeighbour(int i, int j, int m, int n) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] distance = new int[m][n];
        // add the 0s into queue and mark them as visited
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int row = node.first;
            int column = node.second;
            int steps = node.third;
            distance[row][column] = steps;
            for (int[] direction : directions) {
                // the adjacent cell
                int x = row + direction[0];
                int y = column + direction[1];
                if (isValidNeighbour(x, y, n, m) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Node(x, y, steps + 1));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        System.out.println(Arrays.deepToString(new ZeroOneMatrix().updateMatrix(mat)));
    }
}
