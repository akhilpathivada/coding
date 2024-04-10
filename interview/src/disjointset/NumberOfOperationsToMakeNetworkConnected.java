/**
 * Date 10/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 */
package disjointset;

public class NumberOfOperationsToMakeNetworkConnected {

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

    public int makeConnected(int n, int[][] connections) {
        DisjointSet disjointSet = new DisjointSet(n);
        int countOfExtraEdges = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            if (disjointSet.findUltimateParent(u) == disjointSet.findUltimateParent(v)) {
                ++countOfExtraEdges;
            } else {
                disjointSet.unionBySize(u, v);
            }
        }
        int countOfConnectedComponents = 0;
        for (int i = 0; i < n; ++i) {
            if (disjointSet.parent[i] == i) {
                ++countOfConnectedComponents;
            }
        }
        int result = countOfConnectedComponents - 1;
        return countOfExtraEdges >= result ? result : -1;
    }

    public static void main(String[] args) {
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        int n = 4;
        System.out.println(new NumberOfOperationsToMakeNetworkConnected().makeConnected(n, connections));
    }
}
