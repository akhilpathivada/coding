/**
 * https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
 * https://www.codingninjas.com/studio/problems/minimum-spanning-tree_631769
 *
 * Time Complexity: O(E * log E) + O(E * log E) ~ O(E * log E), where E = no. of given edges.
 * Space Complexity: O(E) + O(V), where E = no. of edges and V = no. of vertices.
 * */
package graph.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    private static final class Pair {
        private final int node;

        private final int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    private int minimumSpanningTree(ArrayList<ArrayList<ArrayList<Integer>>> adjacencyList, int n) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        // start with an arbitrary node '0'
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
            for (int i = 0; i <  adjacencyList.get(node).size(); ++i) {
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
        int n = 5;
        int[][] edges = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 1 }, { 4, 2, 2 } };
        ArrayList<ArrayList<ArrayList<Integer>>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjacencyList.add(new ArrayList<>());
        }
        // form the adjacency list
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            ArrayList<Integer> temp1 = new ArrayList<>(Arrays.asList(v, w));
            ArrayList<Integer> temp2 = new ArrayList<>(Arrays.asList(u, w));
            adjacencyList.get(u).add(temp1);
            adjacencyList.get(v).add(temp2);
        }
        System.out.println(new PrimsAlgorithm().minimumSpanningTree(adjacencyList, n));
    }
}
