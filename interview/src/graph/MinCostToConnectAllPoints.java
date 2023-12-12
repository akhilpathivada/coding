/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/description/
 *
 * Time Complexity: O(E * log E) + O(E * log E) ~ O(E * log E), where E = no. of given edges.
 * Space Complexity: O(E) + O(V), where E = no. of edges and V = no. of vertices.
 * */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    class Pair {
        private final int node;

        private final int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    private ArrayList<ArrayList<ArrayList<Integer>>> createGraph(int[][] points, int n) {
        ArrayList<ArrayList<ArrayList<Integer>>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjacencyList.add(new ArrayList<>());
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }
                int edgeWeight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                ArrayList<Integer> temp1 = new ArrayList<>(Arrays.asList(j, edgeWeight));
                adjacencyList.get(i).add(temp1);
            }
        }
        return adjacencyList;
    }

    private int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // create the graph from the given points
        ArrayList<ArrayList<ArrayList<Integer>>> adjacencyList = createGraph(points, n);
        // apply the prims algorithm
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        // start with an aribitary node '0'
        minHeap.add(new Pair(0, 0));
        int sum = 0;
        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            int weight = current.distance;
            int node = current.node;
            // if node is already visited
            if (visited[node]) {
                continue;
            }
            // mark it as visited
            visited[node] = true;
            sum += weight;
            // iterate over all the adjacent nodes
            for (int i = 0; i < adjacencyList.get(node).size(); ++i) {
                int edgeWeight = adjacencyList.get(node).get(i).get(1);
                int adjacentNode = adjacencyList.get(node).get(i).get(0);
                if (!visited[adjacentNode]) {
                    minHeap.add(new Pair(edgeWeight, adjacentNode));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(points));
    }
}
