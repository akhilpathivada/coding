/**
 * @author akhilpathivada
 * <p>
 * date : 03/04/24
 * time: 07:55
 *
 * https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
 *
 * Time Complexity: O(100000 * N)
 * Space Complexity: O(100000 * N)
 */
package graph.dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {

    private static final int MOD = 100000;

    private static class Pair {

        private final int vertex;

        private final int distance;

        private Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    private int minimumMultiplications(int[] arr, int start, int end) {
        // multiplications required to reach the node i.e., distance to reach the node
        int[] dist = new int[MOD];
        // fill the distance with infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, dist[start]));
        while (!queue.isEmpty()) {
            int currentNode = queue.peek().vertex;
            int currentDistance = queue.peek().distance;
            queue.remove();
            for (int num : arr) {
                int newNode = (currentNode * num) % MOD;
                if (currentDistance + 1 < dist[newNode]) {
                    dist[newNode] = currentDistance + 1;
                    if (newNode == end) {
                        return dist[newNode];
                    }
                    queue.add(new Pair(newNode, dist[newNode]));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // input-1
        int[] arr = { 2, 5, 7 };
        int start = 3, end = 30;
//        // input-2
//        int[] arr = { 3, 4, 65 };
//        int start = 7, end = 66175;
        System.out.print(new MinimumMultiplicationsToReachEnd().minimumMultiplications(arr, start, end));
    }
}
