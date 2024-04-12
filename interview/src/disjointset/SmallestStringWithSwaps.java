package disjointset;

import java.util.*;

/**
 * Date 10/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/smallest-string-with-swaps/description/
 *
 *
 */
public class SmallestStringWithSwaps {

    private static final class DisjointSet {

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

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DisjointSet disjointSet = new DisjointSet(n);
        for (List<Integer> pair : pairs) {
            disjointSet.unionBySize(pair.get(0), pair.get(1));
        }
        // store (index of root, children in sorted order)
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int root = disjointSet.findUltimateParent(i);
            map.computeIfAbsent(root, m -> new PriorityQueue<>()).add(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int root = disjointSet.findUltimateParent(i);
            result.append(map.get(root).poll());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(0, 3)));
        pairs.add(new ArrayList<>(Arrays.asList(1, 2)));
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps(s, pairs));
    }
}
