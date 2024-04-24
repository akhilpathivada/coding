/**
 * Date 22/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/redundant-connection/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package disjointset;

import java.util.Arrays;

public class RedundantConnectionI {

        private static final class DisjointSet {

                private final int[] size; // stores size

                private final int[] parent; // stores parent of each node

                private DisjointSet(int n) {
                        // create with n + 1 size: so that it would be useful for 0-indexed and 1-indexed as well
                        size = new int[n + 1];
                        parent = new int[n + 1];
                        // initially every node itself is a disjoint set
                        // so parent of a node is itself and also
                        // the size of every node is 1
                        for (int i = 0; i <= n; ++i) {
                                parent[i] = i;
                                size[i] = 1;
                        }
                }

                // to find the ultimate parent of a node
                // and do "path compression"
                private int findUltimateParent(int node) {
                        // this the ultimate parent (root)
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

        private int[] findRedundantConnection(int[][] edges) {
                final DisjointSet disjointSet = new DisjointSet(edges.length);
                for (int[] edge : edges) {
                        int u = edge[0];
                        int v = edge[1];
                        if (disjointSet.findUltimateParent(u) == disjointSet.findUltimateParent(v)) {
                                return edge;
                        }
                        disjointSet.unionBySize(u, v);
                }
                return null;
        }

        public static void main(String[] args) {
                int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
                System.out.println(Arrays.toString(new RedundantConnectionI().findRedundantConnection(edges)));
        }
}
