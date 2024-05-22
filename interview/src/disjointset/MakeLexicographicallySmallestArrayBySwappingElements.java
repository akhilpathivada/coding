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

    private final class DisjointSet {

        private final int[] parent;

        private final int[] size;

        private DisjointSet(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }

        private void unionBySize(int u, int v) {
            int ultimateParentOfU = findUltimateParent(u);
            int ultimateParentOfV = findUltimateParent(v);
            // if both are already in same set
            if (ultimateParentOfU == ultimateParentOfV) {
                return;
            }
            if (size[ultimateParentOfU] < size[ultimateParentOfV]) {
                parent[ultimateParentOfU] = ultimateParentOfV;
                size[ultimateParentOfV] += size[ultimateParentOfU];
            } else {
                parent[ultimateParentOfV] = ultimateParentOfU;
                size[ultimateParentOfU] += size[ultimateParentOfV];
            }
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        final int n = nums.length;
        final DisjointSet disjointSet = new DisjointSet(n);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (Math.abs(nums[i] - nums[j]) <= limit) {
                    disjointSet.unionBySize(i, j);
                }
            }
        }
        final Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int root = disjointSet.findUltimateParent(i);
            if (!map.containsKey(root)) {
                map.put(root, new PriorityQueue<>());
            }
            map.get(root).offer(nums[i]);
        }
        final int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            int root = disjointSet.findUltimateParent(i);
            result[i] = map.get(root).poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,9,35,60,73,91,61,57,87,76};
        int limit = 11;
        System.out.println(Arrays.toString(new MakeLexicographicallySmallestArrayBySwappingElements().lexicographicallySmallestArray(nums, limit)));
    }
}
