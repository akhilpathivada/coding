/**
 * author: akhilpathivada
 * time: 22/05/24 18:22
 *
 * https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/description/
 *
 */
package disjointset;

import java.util.*;

public class MakeLexicographicallySmallestArrayBySwappingElements {

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

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        final int n = nums.length;
        final DisjointSet disjointSet = new DisjointSet(n);
        final List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            pairs.add(new Pair(i, nums[i]));
        }
        pairs.sort((a, b) -> a.value - b.value);
        for (int i = 1; i < n; ++i) {
            Pair u = pairs.get(i);
            Pair v = pairs.get(i - 1);
            if (u.value - v.value <= limit) {
                disjointSet.union(u.index, v.index);
            }
        }
        final Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (Pair pair : pairs) {
            int root = disjointSet.findUltimateParent(pair.index);
            map.computeIfAbsent(root, q -> new LinkedList<>()).offer(pair.value);
        }
        final int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            int root = disjointSet.findUltimateParent(i);
            result[i] = map.get(root).poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 35, 60, 73, 91, 61, 57, 87, 76};
        int limit = 11;
        System.out.println(Arrays.toString(new MakeLexicographicallySmallestArrayBySwappingElements().lexicographicallySmallestArray(nums, limit)));
    }
}
