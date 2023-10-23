package graph;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {

    private int timer = 1;

    private void dfs(int node, int parent, int[] visited, int[] timeOfVisit, int[] lowestTimeOfVisit,
            List<List<Integer>> adj, List<Integer> articulationPoints) {
        visited[node] = 1;
        timeOfVisit[node] = lowestTimeOfVisit[node] = timer++;
        for (Integer _node : adj.get(node)) {
            if (_node == parent) {
                continue;
            }
            if (visited[_node] == 0) {
                dfs(_node, node, visited, timeOfVisit, lowestTimeOfVisit, adj, articulationPoints);
                lowestTimeOfVisit[node] = Math.min(lowestTimeOfVisit[node], lowestTimeOfVisit[_node]);
                // if this connection is a bridge
                if (lowestTimeOfVisit[_node] >= timeOfVisit[node] && parent != -1) {
                    articulationPoints.add(node);
                }
            } else {
                lowestTimeOfVisit[node] = Math.min(lowestTimeOfVisit[node], lowestTimeOfVisit[_node]);
            }
        }
    }

    private List<Integer> findArticulationPoint(int n, List<List<Integer>> connections) {
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
        List<Integer> articulationPoints = new ArrayList<>();
        dfs(0, -1, visited, timeOfVisit, lowestTimeOfVisit, adj, articulationPoints);
        return articulationPoints;
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
        System.out.println(new ArticulationPoint().findArticulationPoint(n, connections));
    }
}
