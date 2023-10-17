/**
 *
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * Time Complexity: O(connections)
 * Space Complexity: O(N)
 * */
package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {

    private void dfs(List<Integer>[] graph, boolean[] visited, int node) {
        visited[node] = true;
        // if a node has no connections
        if (graph[node].isEmpty()) {
            return;
        }
        // iterate over all it's connections
        for (int _node : graph[node]) {
            if (!visited[_node]) {
                dfs(graph, visited, _node);
            }
        }
    }

    private int numberOfComponents(List<Integer>[] graph, int n) {
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                ++components;
                dfs(graph, visited, i);
            }
        }
        return components;
    }

    private int makeConnected(int[][] connections, int n) {
        // base case
        // we need atleast n - 1 cables to connected n computers
        if (connections.length < n - 1) {
            return -1;
        }
        // form the graph
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
        // find the no. of components
        int components = numberOfComponents(graph, n);
        return components - 1;
    }

    public static void main(String[] args) {
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        int n = 4;
        System.out.println(new NumberOfOperationsToMakeNetworkConnected().makeConnected(connections, n));
    }
}
