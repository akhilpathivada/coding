/**
 * author: akhilpathivada
 * time: 09/05/24 07:22
 *
 * https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/description/
 *
 */
package graph.dijkstra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NumberOfRestrictedPathsFromFirstToLastNode {

    private static final int MOD = (int) 1e9 + 7;

    private static class Pair {

        private final int vertex;

        private final int distance;

        private Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private int findRestrictedPaths(int node, int target, int[] dist, int[] dp, Map<Integer, Map<Integer, Integer>> graph) {
        if (node == target) {
            return 1;
        }
        if (dp[node] != -1) {
            return dp[node];
        }
        int count = 0;
        for (int adjacentNode : graph.get(node).keySet()) {
            if (dist[node] > dist[adjacentNode]) {
                count = (count + findRestrictedPaths(adjacentNode, target, dist, dp, graph)) % MOD;
            }
        }
        return dp[node] = count;
    }

    private Map<Integer, Map<Integer, Integer>> createGraph(int[][] edges) {
        Map<Integer, Map<Integer, Integer>> adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], m -> new HashMap<>()).put(edge[1], edge[2]);
            adjacencyList.computeIfAbsent(edge[1], m -> new HashMap<>()).put(edge[0], edge[2]);
        }
        return adjacencyList;
    }

    private int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> graph = createGraph(edges);
        final PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        final int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        minHeap.add(new Pair(n, dist[n]));
        while (!minHeap.isEmpty()) {
            int node = minHeap.peek().vertex;
            int distance = minHeap.peek().distance;
            minHeap.remove();
            for (Map.Entry<Integer, Integer> edge : graph.get(node).entrySet()) {
                int adjacentNode = edge.getKey();
                int edW = edge.getValue();
                if (distance + edW < dist[adjacentNode]) {
                    dist[adjacentNode] = distance + edW;
                    minHeap.add(new Pair(adjacentNode, dist[adjacentNode]));
                }
            }
        }
        final int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findRestrictedPaths(1, n, dist, dp, graph);
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}};
        System.out.println(new NumberOfRestrictedPathsFromFirstToLastNode().countRestrictedPaths(n, edges));
    }
}
