/**
 *
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
 *
 * Time Complexity: O(V ^ 3)
 * Space Complexity: O(V ^ 2)
 * */
package graph;

import java.util.Arrays;

public class CityWithTheSmallestNumberOfNeighbors {

    private int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // form the distance matrix
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        System.out.println(Arrays.deepToString(dist));
        // using Floyd Warshall Algorithm
        // calculate all pairs shortest path
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dist));
        int smallestCountOfNeighbors = n;
        int cityNumber = -1;
        for (int city = 0; city < n; ++city) {
            int count = 0;
            for (int adjCity = 0; adjCity < n; ++adjCity) {
                if (city != adjCity && dist[city][adjCity] != Integer.MAX_VALUE && dist[city][adjCity] <= distanceThreshold) {
                    ++count;
                }
            }
            if (count <= smallestCountOfNeighbors) {
                smallestCountOfNeighbors = count;
                cityNumber = city;
            }
        }
        return cityNumber;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        int distanceThreshold = 4;
        System.out.println(new CityWithTheSmallestNumberOfNeighbors().findTheCity(n, edges, distanceThreshold));
    }
}
