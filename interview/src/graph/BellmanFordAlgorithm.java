/**
 * https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/
 * https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
 *
 * Time Complexity: O(V * E)
 * Space Complexity: O(V)
 * */
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {

    private int[] bellmonFord(int n, int src, List<List<Integer>> edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        // iterate (N - 1) times
        for (int i = 0; i < n - 1; ++i) {
            for (List<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int weight = it.get(2);
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        // Nth iteration to detect the negative cycle
        for (List<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int weight = it.get(2);
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                return new int[] { -1 };
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1, -1));
        edges.add(Arrays.asList(0, 2, 4));
        edges.add(Arrays.asList(1, 2, 3));
        edges.add(Arrays.asList(1, 3, 2));
        edges.add(Arrays.asList(1, 4, 2));
        edges.add(Arrays.asList(3, 2, 5));
        edges.add(Arrays.asList(3, 1, 1));
        edges.add(Arrays.asList(4, 3, -3));
        int src = 0;
        int n = 5;
        System.out.println(Arrays.toString(new BellmanFordAlgorithm().bellmonFord(n, src, edges)));
    }
}
