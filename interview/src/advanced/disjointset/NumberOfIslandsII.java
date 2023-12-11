/**
 * https://www.codingninjas.com/studio/problems/number-of-islands-ii_1266048
 * https://www.geeksforgeeks.org/problems/number-of-islands/1
 *
 * Time Complexity: O(Q * 4α) ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.
 * Space Complexity: O(Q) + O(N * M) + O(N * M), where Q = no. of queries, N = total no. of rows, M = total no. of columns.
 * */
package advanced.disjointset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {

    private boolean isValidNeighbour(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private int[] numOfIslandsII(int n, int m, int[][] queries) {
        DisjointSet disjointSet = new DisjointSet(n * m);
        boolean[][] visited = new boolean[n][m];
        int counfOfIslands = 0;
        // the four directions we can check
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        List<Integer> result = new ArrayList<>();
        for (int[] current : queries) {
            int row = current[0];
            int column = current[1];
            if (visited[row][column]) {
                result.add(counfOfIslands);
                continue;
            }
            visited[row][column] = true;
            ++counfOfIslands;
            for (int[] direction : directions) {
                int x = row + direction[0];
                int y = column + direction[1];
                if (isValidNeighbour(x, y, n, m)) {
                    if (visited[x][y]) {
                        int currentNodeNumber = row * m + column;
                        int adjacentNodeNumber = x * m + y;
                        if (disjointSet.findUltimateParent(currentNodeNumber) != disjointSet.findUltimateParent(adjacentNodeNumber)) {
                            --counfOfIslands;
                            disjointSet.unionBySize(currentNodeNumber, adjacentNodeNumber);
                        }
                    }
                }
            }
            result.add(counfOfIslands);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] queries = { { 0, 0 }, { 0, 0 }, { 1, 1 }, { 1, 0 }, { 0, 1 }, { 0, 3 }, { 1, 3 }, { 0, 4 }, { 3, 2 },
                { 2, 2 }, { 1, 2 }, { 0, 2 } };
        System.out.println(Arrays.toString(new NumberOfIslandsII().numOfIslandsII(n, m, queries)));
    }
}
