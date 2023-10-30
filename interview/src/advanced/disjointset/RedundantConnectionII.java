/**
 * https://leetcode.com/problems/redundant-connection-ii/description/
 * */
package advanced.disjointset;

import java.util.Arrays;

public class RedundantConnectionII {

    private class DisjointSet {
        private int[] rank;
        private int[] parent;
        private int[] directParent;

        public DisjointSet(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            directParent = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
            }
        }

        public int findUltimateParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            parent[node] = findUltimateParent(parent[node]);
            return parent[node];
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);
        int[] ans2 = null;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (disjointSet.directParent[v] > 0) {
                ans2 = edge;
            }
            disjointSet.directParent[v] = u;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (edge == ans2) {
                continue;
            }
            int ultimateParentOfU = disjointSet.findUltimateParent(u);
            int ultimateParentOfV = disjointSet.findUltimateParent(v);
            // a cycle
            if (ultimateParentOfU == ultimateParentOfV) {
                ans2 = edge;
            }
            disjointSet.parent[ultimateParentOfV] = ultimateParentOfU;
        }
        return ans2;
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 5 } };
        System.out.println(Arrays.toString(new RedundantConnectionII().findRedundantDirectedConnection(edges)));
    }
}
