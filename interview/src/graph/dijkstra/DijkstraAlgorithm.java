/**
 * https://www.geeksforgeeks.org/introduction-to-dijkstras-shortest-path-algorithm/
 *
 * Time Complexity: O(E * log(V))
 * Space Complexity: O(V ^ 2)
 * */
package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    private static class Node implements Comparable<Node> {

        private final int vertex;
        private final int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            if (this.distance <= node.distance) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private int[] dijkstra(int V, List<List<List<Integer>>> adjacencyList, int S) {
        // stores the distance to each vertex from source
        int[] dist = new int[V];
        // fill the distance with infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        // distance of source from source is always 0
        dist[S] = 0;
        // min heap holds the least weighted edge from a given vertex
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        // initially add the source vertex and it's distance
        minHeap.add(new Node(S, 0));
        while (!minHeap.isEmpty()) {
            // get the least weighted edge
            Node node = minHeap.poll();
            int u = node.vertex;
            int distance = node.distance;
            // iterate over all the edges
            for (List<Integer> edge : adjacencyList.get(u)) {
                int v = edge.get(0);
                int w = edge.get(1);
                // if we found a better path with lesser distance
                if (w + distance < dist[v]) {
                    dist[v] = w + distance;
                    minHeap.add(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        List<List<List<Integer>>> adjacencyList = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        int V = 6;
        int E = 5;
        int[] u = { 0, 0, 1, 2, 4 };
        int[] v = { 3, 5, 4, 5, 5 };
        int[] w = { 9, 4, 4, 10, 3 }; // weights

        for (int i = 0; i < E; ++i) {
            List<Integer> edge = new ArrayList<>();
            edge.add(v[i]);
            edge.add(w[i]);
            List<List<Integer>> adjList;
            if (!map.containsKey(u[i])) {
                adjList = new ArrayList<>();
            } else {
                adjList = map.get(u[i]);
            }
            adjList.add(edge);
            map.put(u[i], adjList);
            ArrayList<Integer> edge2 = new ArrayList<>();
            edge2.add(u[i]);
            edge2.add(w[i]);

            List<List<Integer>> adjList2;
            if (!map.containsKey(v[i])) {
                adjList2 = new ArrayList<>();
            } else {
                adjList2 = map.get(v[i]);
            }
            adjList2.add(edge2);
            map.put(v[i], adjList2);

        }
        for (int i = 0; i < V; i++) {
            adjacencyList.add(map.getOrDefault(i, null));
        }
        // source
        int S = 1;
        /**
         Input sample
         [
            0 [[3, 9], [5, 4]],
            1 [[4, 4]],
            2 [[5, 10]],
            3 [[0, 9]],
            4 [[1, 4], [5, 3]],
            5 [[0, 4], [2, 10], [4, 3]]
         ]
         */
        System.out.println(Arrays.toString(new DijkstraAlgorithm().dijkstra(V, adjacencyList, S)));
    }
}
