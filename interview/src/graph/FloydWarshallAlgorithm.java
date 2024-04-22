/**
 * https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 *
 * Time Complexity: O(V ^ 3)
 * Space Complexity: O(V ^ 2)
 * */
package graph;

import java.util.Arrays;

public class FloydWarshallAlgorithm {

    private static final int INF = (int) 1e9;

    private void shortestDistance(int[][] matrix) {
        int n = matrix.length;
        // replace -1 with INFINITY
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = INF;
                } else if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }
        // algorithm
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        // replace INFINITY with -1
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == INF) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 5, -1, 10 }, { -1, 0, 3, -1 }, { -1, -1, 0, 1 }, { -1, -1, -1, 0 } };
        new FloydWarshallAlgorithm().shortestDistance(graph);
        System.out.println(Arrays.deepToString(graph));
    }
}
