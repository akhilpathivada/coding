/**
 * author: akhilpathivada
 * time: 22/05/24 21:26
 *
 * https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/description/
 *
 */
package disjointset;

import java.util.*;

public class MinimizeHammingDistanceAfterSwapOperations {

    private final class Pair {

        private final int index;

        private final int value;

        private Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private final class DisjointSet {

        private final int[] parent;

        private DisjointSet(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
            }
        }

        private int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }

        private void union(int u, int v) {
            parent[v] = u;
        }
    }

    private int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        final DisjointSet disjointSet = new DisjointSet(n);
        for (int[] pair : allowedSwaps) {
            int u = pair[0];
            int v = pair[1];
            if (disjointSet.findUltimateParent(u) != disjointSet.findUltimateParent(v)) {
                disjointSet.union(u, v);
            }
        }
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int root = disjointSet.findUltimateParent(i);
            map.computeIfAbsent(root, l -> new HashSet<>()).add(source[i]);
        }
        int hammingCount = 0;
        for (int i = 0; i < n; ++i) {
            int root = disjointSet.findUltimateParent(i);
            if (source[i] == target[i]) {
                map.get(root).remove(source[i]);
            } else if (source[i] != target[i]) {

            }
        }
        return hammingCount;
    }

    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] allowedSwaps = {{0, 1}, {2, 3}};
        System.out.println(new MinimizeHammingDistanceAfterSwapOperations().minimumHammingDistance(source, target, allowedSwaps));
    }
}
