/**
 * https://www.geeksforgeeks.org/bridge-in-a-graph/
 *
 * https://leetcode.com/problems/critical-connections-in-a-network/description/
 *
 * Time Complexity: O(V + 2E). time taken for dfs traversal
 * Space Complexity: O(V + 2E)
 * */
package graph.bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInNetwork {
    private int timer = 1;

    private void dfs(final int node, final int parent, final int[] visited, final int[] timeOfVisit, final int[] lowestTimeOfVisit,
                     final List<List<Integer>> adjacencyList, final List<List<Integer>> bridges) {
        visited[node] = 1;
        timeOfVisit[node] = lowestTimeOfVisit[node] = timer++;
        for (Integer adjacentNode : adjacencyList.get(node)) {
            if (adjacentNode == parent) {
                continue;
            }
            if (visited[adjacentNode] == 0) {
                dfs(adjacentNode, node, visited, timeOfVisit, lowestTimeOfVisit, adjacencyList, bridges);
                lowestTimeOfVisit[node] = Math.min(lowestTimeOfVisit[node], lowestTimeOfVisit[adjacentNode]);
                // if this connection is a bridge
                if (lowestTimeOfVisit[adjacentNode] > timeOfVisit[node]) {
                    bridges.add(Arrays.asList(adjacentNode, node));
                }
            } else {
                lowestTimeOfVisit[node] = Math.min(lowestTimeOfVisit[node], lowestTimeOfVisit[adjacentNode]);
            }
        }
    }

    private List<List<Integer>> findBridges(int n, List<List<Integer>> connections) {
        // forming an adjacency list
        final List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjacencyList.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        final int[] visited = new int[n];
        final int[] timeOfVisit = new int[n];
        final int[] lowestTimeOfVisit = new int[n];
        final List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, visited, timeOfVisit, lowestTimeOfVisit, adjacencyList, bridges);
        return bridges;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
                {0, 1}, {1, 2},
                {2, 0}, {1, 3}
        };
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(edges[i][0]);
            connections.get(i).add(edges[i][1]);
        }
        System.out.println(new CriticalConnectionsInNetwork().findBridges(n, connections));
    }
}
