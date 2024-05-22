/**
 * author: akhilpathivada
 * time: 22/05/24 09:51
 *
 * https://leetcode.com/problems/reachable-nodes-with-restrictions/description/
 *
 */
package disjointset;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ReachableNodesWithRestrictions {

    private final class DisjointSet {

        private final int[] size;
        private final int[] parent;

        public DisjointSet(int n) {
            size = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }

        public void unionBySize(int u, int v) {
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

    private int reachableNodes(int n, int[][] edges, int[] restricted) {
        final Set<Integer> restrictedSet = Arrays.stream(restricted).boxed().collect(Collectors.toSet());
        final DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (restrictedSet.contains(u) || restrictedSet.contains(v)) {
                continue;
            }
            disjointSet.unionBySize(u, v);
        }
        return Arrays.stream(disjointSet.size).max().getAsInt();
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{2, 1}, {1, 0}, {0, 3}};
        int[] restricted = {2, 3};
        System.out.println(new ReachableNodesWithRestrictions().reachableNodes(n, edges, restricted));
    }
}
