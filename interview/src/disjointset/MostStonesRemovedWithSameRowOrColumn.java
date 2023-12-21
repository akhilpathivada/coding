/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
 *
 *
 * */
package disjointset;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {

    private int removeStones(int[][] stones) {
        // no. of stones
        int n = stones.length;
        int maxRow = 0;
        int maxColumn = 0;
        for (int[] stoneCoordinate : stones) {
            maxRow = Math.max(maxRow, stoneCoordinate[0]);
            maxColumn = Math.max(maxColumn, stoneCoordinate[1]);
        }
        DisjointSet disjointSet = new DisjointSet(maxRow + maxColumn + 1);
        // to capture only the nodes(cells) having the stones
        Set<Integer> stoneNodes = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            int rowOfTheNode = stones[i][0];
            int columnOfTheNode = stones[i][1] + maxRow + 1;
            disjointSet.unionBySize(rowOfTheNode, columnOfTheNode);
            stoneNodes.add(rowOfTheNode);
            stoneNodes.add(columnOfTheNode);
        }
        // calculate the no. of disjoint sets
        int count = 0;
        for (int stoneNode : stoneNodes) {
            if (disjointSet.findUltimateParent(stoneNode) == stoneNode) {
                ++count;
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println(new MostStonesRemovedWithSameRowOrColumn().removeStones(stones));
    }
}
