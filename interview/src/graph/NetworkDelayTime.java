/**
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * Time Complexity: O(E * log(V))
 * Space Complexity: O(V ^ 2)
 * */
package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    private int networkDelayTime(int[][] times, int n, int k) {
        // create a graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        // stores the distance to each vertex from source
        int[] dist = new int[n + 1];
        // fill the distance with infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        // distance of source from source is always 0
        dist[k] = 0;
        // min heap holds the least weighted edge from a given vertex
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        // initially add the source vertex and it's distance
        minHeap.add(new int[] { k, 0 });

        while (!minHeap.isEmpty()) {
            // get the least weighted edge
            int[] edge = minHeap.poll();
            int u = edge[0];
            int distance = edge[1];
            // ignore if a node doesn't have any outgoing edges
            if (!graph.containsKey(u)) {
                continue;
            }
            // iterate over all the edges
            for (Map.Entry<Integer, Integer> _edge : graph.get(u).entrySet()) {
                int v = _edge.getKey();
                int w = _edge.getValue();
                // if we found a better path with lesser distance
                if (w + distance < dist[v]) {
                    dist[v] = w + distance;
                    minHeap.add(new int[] { v, dist[v] });
                }
            }
        }
        int maxDistance = Integer.MIN_VALUE;
        // the max. distance taken to reach a node would be our required answer
        for (int i = 1; i <= n; ++i) {
            maxDistance = Math.max(maxDistance, dist[i]);
        }
        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }

    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;
        System.out.println(new NetworkDelayTime().networkDelayTime(times, n, k));
    }
}
