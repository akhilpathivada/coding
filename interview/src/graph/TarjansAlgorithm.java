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

    private void dfs(int node, int parent, int[] visited, int[] timeOfInsertion, int[] lowestTimeOfInsertion,
            List<List<Integer>> adj, List<List<Integer>> bridges) {
        visited[node] = 1;
        timeOfInsertion[node] = lowestTimeOfInsertion[node] = timer;
        ++timer;
        for (Integer _node : adj.get(node)) {
            if (_node == parent) {
                continue;
            }
            if (visited[_node] == 0) {
                dfs(_node, node, visited, timeOfInsertion, lowestTimeOfInsertion, adj, bridges);
                lowestTimeOfInsertion[node] = Math.min(lowestTimeOfInsertion[node], lowestTimeOfInsertion[_node]);
                // if this connection is a bridge
                if (lowestTimeOfInsertion[_node] > timeOfInsertion[node]) {
                    bridges.add(Arrays.asList(_node, node));
                }
            } else {
                lowestTimeOfInsertion[node] = Math.min(lowestTimeOfInsertion[node], lowestTimeOfInsertion[_node]);
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
        int[] timeOfInsertion = new int[n];
        int[] lowestTimeOfInsertion = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, visited, timeOfInsertion, lowestTimeOfInsertion, adj, bridges);
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
            connections.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(edges[i][0]);
            connections.get(i).add(edges[i][1]);
        }
        System.out.println(new TarjansAlgorithm().findBridges(n, connections));
    }
}
