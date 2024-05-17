/**
 * author: akhilpathivada
 * time: 17/05/24 15:33
 *
 * https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/description/
 *
 */
package disjointset;

import java.util.Arrays;

public class CheckingExistenceOfEdgeLengthLimitedPaths {

    // unfinished logic
    private boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        final int[][] matrix = new int[n][n];
        for (int[] row : matrix) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int[] edge : edgeList) {
            matrix[edge[0]][edge[1]] = edge[2];
        }
        // apply floyd-warshall algorithm
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        final boolean[] answer = new boolean[queries.length];
        int i = 0;
        for (int[] query : queries) {
            answer[i++] = (matrix[query[0]][query[1]] < query[2]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edgeList = {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}};
        int[][] queries = {{0, 1, 2}, {0, 2, 5}};
        System.out.println(Arrays.toString(new CheckingExistenceOfEdgeLengthLimitedPaths().distanceLimitedPathsExist(n, edgeList, queries)));
    }
}
