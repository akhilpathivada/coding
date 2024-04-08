/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 *
 * Time Complexity : O(E) where E is the no. of edges, means the flights size
 * Space Complexity : O(N)
 * */
package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    private class Pair implements Comparable<Pair> {
        private final int v;
        public final int price;

        private Pair(int v, int weight) {
            this.v = v;
            this.price = weight;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.price <= pair.price) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private class Tuple {
        private final int stops; // no. of stops taken to reach to this node
        private final int source; // name of this node
        private final int price; // price taken to reach to this node

        private Tuple(int stops, int source, int price) {
            this.stops = stops;
            this.source = source;
            this.price = price;
        }
    }

    private int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // create a graph based on the data
        List<List<Pair>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : flights) {
            adj.get(p[0]).add(new Pair(p[1], p[2]));
        }
        // stores the distance to each vertex from source
        int[] prices = new int[n];
        // fill the distance with infinity
        Arrays.fill(prices, Integer.MAX_VALUE);
        Queue<Tuple> queue = new LinkedList<>();
        // {stops, node, price}
        queue.add(new Tuple(0, src, 0));
        // price taken to reach source is always '0'
        prices[src] = 0;
        while (!queue.isEmpty()) {
            Tuple node = queue.poll();
            int stops = node.stops;
            int source = node.source;
            int price = node.price;
            // if stops exceed 'k' no need to consider this path anymore
            if (stops > k) {
                continue;
            }
            for (Pair p : adj.get(source)) {
                int v = p.v;
                int edW = p.price; // edge weight or price
                if (price + edW < prices[v]) {
                    prices[v] = price + edW;
                    queue.add(new Tuple(stops + 1, v, price + edW));
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(n, flights, src, dst, k));
    }
}
