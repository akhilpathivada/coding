package graph.dijkstra;

import java.util.*;

/**
 * Date 21/04/24
 * Time 18:36
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-time-to-visit-disappearing-nodes/description/
 *
 */
public class MinimumTimeToVisitDisappearingNodes {

    private int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // convert to graph (adjacency list)
        final Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        // populate edges into the adjacency list
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], m -> new HashMap<>()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], m -> new HashMap<>()).put(edge[0], edge[2]);
        }
        final PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{0, 0});
        final boolean[] visited = new boolean[n];
        final int[] timeToReach = new int[n];
        Arrays.fill(timeToReach, Integer.MAX_VALUE);
        timeToReach[0] = 0;
        while (!minHeap.isEmpty()) {
            int currentNode = minHeap.peek()[0];
            int currentTime = minHeap.peek()[1];
            minHeap.remove();
            if (!graph.containsKey(currentNode) || visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;
            for (Map.Entry<Integer, Integer> entry : graph.get(currentNode).entrySet()) {
                int adjacentNode = entry.getKey();
                int expectedTimeToReachAdjacentNode = currentTime + entry.getValue();
                if (expectedTimeToReachAdjacentNode < timeToReach[adjacentNode]
                        && expectedTimeToReachAdjacentNode < disappear[adjacentNode]) {
                    timeToReach[adjacentNode] = expectedTimeToReachAdjacentNode;
                    minHeap.add(new int[]{adjacentNode, timeToReach[adjacentNode]});
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (timeToReach[i] == Integer.MAX_VALUE) {
                timeToReach[i] = -1;
            }
        }
        return timeToReach;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1, 2}, {1, 2, 1}, {0, 2, 4}};
        int[] disappear = {1, 1, 5};
        System.out.println(Arrays.toString(new MinimumTimeToVisitDisappearingNodes().minimumTime(n, edges, disappear)));
    }
}
