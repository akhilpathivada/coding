/**
 * author: akhilpathivada
 * time: 09/05/24 06:22
 *
 * https://leetcode.com/problems/minimum-cost-of-a-path-with-special-roads/description/
 *
 */
package graph.dijkstra;

import java.util.Map;

public class MinimumCostOfAPathWithSpecialRoads {

    private static final class Node {

        private final int x;

        private final int y;

        private final int cost;

        private Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        return 1;
    }

    public static void main(String[] args) {
        int[] start = {1, 1};
        int[] target = {4, 5};
        int[][] specialRoads = {{1, 2, 3, 3, 2}, {3, 4, 4, 5, 1}};
        System.out.println(new MinimumCostOfAPathWithSpecialRoads().minimumCost(start, target, specialRoads));
    }
}
