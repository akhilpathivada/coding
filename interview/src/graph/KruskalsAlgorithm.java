/**
 * https://www.codingninjas.com/studio/problems/kruskal-s-minimum-spanning-tree-algorithm_1082553
 *
 * Time Complexity: O(M) * 4 * alpha * 2 where M is number of given edges
 * Space Complexity: O(M)
 * */
package graph;

import advanced.disjointset.DisjointSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {

    class Edge implements Comparable<Edge> {

        private final int src;

        private final int dest;

        private final int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private int minimumSpanningTree(ArrayList<ArrayList<ArrayList<Integer>>> adjacencyList, int n) {
        int sum = 0;
        List<Edge> edges = new ArrayList<>();
        for (int currentNode = 0; currentNode < n; ++currentNode) {
            for (int i = 0; i < adjacencyList.get(currentNode).size(); ++i) {
                int adjacentNode = adjacencyList.get(currentNode).get(i).get(0);
                int weight = adjacencyList.get(currentNode).get(i).get(1);
                Edge edge = new Edge(currentNode, adjacentNode, weight);
                edges.add(edge);
            }
        }
        // sort the edges based on weights (in ascending order)
        Collections.sort(edges);
        DisjointSet disjointSet = new DisjointSet(n);
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (disjointSet.findUltimateParent(u) != disjointSet.findUltimateParent(v)) {
                sum += weight;
                disjointSet.unionBySize(u, v);
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
        System.out.println(new KruskalsAlgorithm().minimumSpanningTree(adjacencyList, n));
    }
}
