/**
 * https://www.geeksforgeeks.org/bridge-in-a-graph/
 *
 * Time Complexity: O(V + 2E).. time taken for dfs traversal
 * Space Complexity: O(V + 2E)
 * */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarjansAlgorithm {

    private int timer = 1;

    private void dfs(int node, int parent, int[] visited, int[] timeOfVisit, int[] lowestTimeOfVisit,
            List<List<Integer>> adj, List<List<Integer>> bridges) {
        visited[node] = 1;
        timeOfVisit[node] = lowestTimeOfVisit[node] = timer++;
        for (Integer _node : adj.get(node)) {
            if (_node == parent) {
                continue;
            }
            if (visited[_node] == 0) {
                dfs(_node, node, visited, timeOfVisit, lowestTimeOfVisit, adj, bridges);
                lowestTimeOfVisit[node] = Math.min(lowestTimeOfVisit[node], lowestTimeOfVisit[_node]);
                // if this connection is a bridge
                if (lowestTimeOfVisit[_node] > timeOfVisit[node]) {
                    bridges.add(Arrays.asList(_node, node));
                }
            } else {
                lowestTimeOfVisit[node] = Math.min(lowestTimeOfVisit[node], lowestTimeOfVisit[_node]);
            }
        }
    }

    private List<List<Integer>> findBridges(int n, List<List<Integer>> connections) {
        // forming an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited = new int[n];
        int[] timeOfVisit = new int[n];
        int[] lowestTimeOfVisit = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, visited, timeOfVisit, lowestTimeOfVisit, adj, bridges);
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
        System.out.println(new TarjansAlgorithm().findBridges(n, connections));
    }
}
