/**
 *
 * Tarjan's Algorithm to find articulation points and bridges
 *
 * https://www.geeksforgeeks.org/bridge-in-a-graph/
 *
 * */
package graph.bridge;

import java.util.ArrayList;
import java.util.List;

public class TarjanAlgorithm {

    private int timer = 1;

    private void dfs(final int node, final int parent, final int[] visited, final int[] timeOfVisit, final int[] lowestTimeOfVisit,
                     final List<List<Integer>> adjacencyList, final List<Integer> articulationPoints) {
        visited[node] = 1;
        timeOfVisit[node] = lowestTimeOfVisit[node] = timer++;
        for (Integer adjacentNode : adjacencyList.get(node)) {
            if (adjacentNode == parent) {
                continue;
            }
            if (visited[adjacentNode] == 0) {
                dfs(adjacentNode, node, visited, timeOfVisit, lowestTimeOfVisit, adjacencyList, articulationPoints);
                lowestTimeOfVisit[node] = Math.min(lowestTimeOfVisit[node], lowestTimeOfVisit[adjacentNode]);
                // if this connection is a bridge
                if (lowestTimeOfVisit[adjacentNode] >= timeOfVisit[node] && parent != -1) {
                    articulationPoints.add(node);
                }
            } else {
                lowestTimeOfVisit[node] = Math.min(lowestTimeOfVisit[node], lowestTimeOfVisit[adjacentNode]);
            }
        }
    }

    private List<Integer> findArticulationPoint(int n, List<List<Integer>> connections) {
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
        final List<Integer> articulationPoints = new ArrayList<>();
        dfs(0, -1, visited, timeOfVisit, lowestTimeOfVisit, adjacencyList, articulationPoints);
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
        System.out.println(new TarjanAlgorithm().findArticulationPoint(n, connections));
    }
}
