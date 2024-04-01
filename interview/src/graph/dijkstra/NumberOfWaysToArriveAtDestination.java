/**
 * @author akhilpathivada
 * <p>
 * date : 30/03/24
 * time: 10:59
 *
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
 *
 * Time Complexity: O(m + n log n)
 * Space Complexity: O(mn)
 */
package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {

    private static final int MOD = (int) (1e9 + 7);

    private static class Pair {

        private final int vertex;

        private final int distance;

        private Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private List<List<Pair>> convertToAdjacencyList(int[][] roads, int n) {
        List<List<Pair>> adjacencyList = new ArrayList<>();
        // initialize the adjacency list
        for (int i = 0; i < n; ++i) {
            adjacencyList.add(new ArrayList<>());
        }
        // populate the adjacency list with road information
        for (int[] road : roads) {
            adjacencyList.get(road[0]).add(new Pair(road[1], road[2]));
            adjacencyList.get(road[1]).add(new Pair(road[0], road[2]));
        }
        return adjacencyList;
    }

    private int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjacencyList = convertToAdjacencyList(roads, n);
        // use dijkstra algorithm
        // stores the distance to each vertex from source
        int[] dist = new int[n];
        // store the no. of ways to reach a node with min. distance
        int[] ways = new int[n];
        // fill the distances with infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        // distance of source from source is always 0
        dist[0] = 0;
        // ways to reach source node is 1
        ways[0] = 1;
        // min heap holds the least weighted edge from a given vertex
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                (Pair1, Pair2) -> Integer.compare(Pair1.distance, Pair2.distance));
        // initially add the source vertex and it's distance
        minHeap.add(new Pair(0, 0));
        while (!minHeap.isEmpty()) {
            // get the least weighted edge
            int node = minHeap.peek().vertex;
            int distance = minHeap.peek().distance;
            minHeap.remove();
            // iterate over all the neighbors
            for (Pair edge : adjacencyList.get(node)) {
                int adjacentNode = edge.vertex;
                int edW = edge.distance;
                // if we found a better path with lesser distance
                if (distance + edW < dist[adjacentNode]) {
                    dist[adjacentNode] = distance + edW;
                    minHeap.add(new Pair(adjacentNode, dist[adjacentNode]));
                    ways[adjacentNode] = ways[node];
                } else if (distance + edW == dist[adjacentNode]) {
                    // if multiple paths with the same length are found : add their ways
                    ways[adjacentNode] = (ways[adjacentNode] + ways[node]) % MOD;
                }
            }
        }
        // return the number of ways to reach the last node modulo mod
        return ways[n - 1] % MOD;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
                { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
        System.out.println(new NumberOfWaysToArriveAtDestination().countPaths(n, roads));
    }
}
