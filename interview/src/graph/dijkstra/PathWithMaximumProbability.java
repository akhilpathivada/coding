/**
 * Date 08/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/path-with-maximum-probability/description/
 *
 * Time Complexity: O(m + n log n)
 * Space Complexity: O(mn)
 */
package graph.dijkstra;

import java.util.*;

public class PathWithMaximumProbability {
    
    private final static class Pair {
        
        private final int node;
        
        private final double probability;

        private Pair(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }

    private Map<Integer, Map<Integer, Double>> convertToAdjacencyList(int n, int[][] edges, double[] succProb) {
        Map<Integer, Map<Integer, Double>> adjacencyList = new HashMap<>();
        // populate the adjacency list with road information
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            adjacencyList.computeIfAbsent(edge[0], m -> new HashMap<>()).put(edge[1], succProb[i]);
            adjacencyList.computeIfAbsent(edge[1], m -> new HashMap<>()).put(edge[0], succProb[i]);
        }
        return adjacencyList;
    }

    private double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, Map<Integer, Double>> adjacencyList = convertToAdjacencyList(n, edges, succProb);
        // if start_node or end_node doesn't exist in graph
        if (!adjacencyList.containsKey(start_node) || !adjacencyList.containsKey(end_node)) {
            return 0;
        }
        // use dijkstra algorithm
        // stores the distance to each vertex from source
        double[] prob = new double[n];
        // fill the probabilities with -infinity
        Arrays.fill(prob, Integer.MIN_VALUE);
        // probability of source from source is 1
        prob[start_node] = 1;
        // min heap holds the least weighted edge from a given vertex
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (Pair1, Pair2) -> Double.compare(Pair2.probability, Pair1.probability));
        // initially add the start node and it's probability
        maxHeap.add(new Pair(start_node, prob[start_node]));
        while (!maxHeap.isEmpty()) {
            // get the max. prob edge
            int node = maxHeap.peek().node;
            double currentProbability = maxHeap.peek().probability;
            maxHeap.remove();
            // iterate over all the neighbors
            for (Map.Entry<Integer, Double> entry : adjacencyList.get(node).entrySet()) {
                int adjacentNode = entry.getKey();
                double edgeProbability = entry.getValue();
                // if we found a better path with more probability
                if (currentProbability * edgeProbability > prob[adjacentNode]) {
                    prob[adjacentNode] = currentProbability * edgeProbability;
                    maxHeap.add(new Pair(adjacentNode, prob[adjacentNode]));
                }
            }
        }
        return prob[end_node] == Integer.MIN_VALUE ? 0 : prob[end_node];
    }

    public static void main(String[] args) {
        int[][] edges = {{ 0, 1 }, { 1, 2 }, { 0, 2 }};
        int n = 3;
        double[] succProb = { 0.5, 0.5, 0.2 };
        int start = 0, end = 2;
//        int n = 3;
//        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 }};
//        double[] succProb = { 0.5, 0.5, 0.3 };
//        int start = 0, end = 2;
//        System.out.println(0.15 > 0.3);
        System.out.println(new PathWithMaximumProbability().maxProbability(n, edges, succProb, start, end));
    }
}
