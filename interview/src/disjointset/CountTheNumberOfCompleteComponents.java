/**
 * author: akhilpathivada
 * time: 27/06/24 17:17
 *
 * https://leetcode.com/problems/count-the-number-of-complete-components/description/
 *
 */
package disjointset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfCompleteComponents {

    private final class DisjointSet {

        private final int[] size;

        private final int[] parent;

        private DisjointSet(int n) {
            size = new int[n + 1];
            parent = new int[n + 1];
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

    private int countCompleteComponents(int n, int[][] edges) {
        final DisjointSet disjointSet = new DisjointSet(n);
        final int[] edgeCount = new int[n];
        for (int[] edge : edges) {
            disjointSet.unionBySize(edge[0], edge[1]);
            edgeCount[edge[0]]++;
            edgeCount[edge[1]]++;
        }
        final Set<Integer> completeComponents = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            completeComponents.add(disjointSet.findUltimateParent(i));
        }
        for (int i = 0; i < n; ++i) {
            int root = disjointSet.findUltimateParent(i);
            if (disjointSet.size[root] != edgeCount[i] + 1) {
                completeComponents.remove(root);
            }
        }
        return completeComponents.size();
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}};
        System.out.println(new CountTheNumberOfCompleteComponents().countCompleteComponents(n, edges));
    }
}
