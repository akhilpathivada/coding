/**
 * author: akhilpathivada
 * time: 22/05/24 07:52
 *
 * https://leetcode.com/problems/count-servers-that-communicate/description/
 *
 */
package disjointset;

public class CountServersThatCommunicate {

    private final class DisjointSet {

        private final int[] size;
        private final int[] parent;

        public DisjointSet(int n) {
            size = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
                size[i] = 0;
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
                size[ultimateParentOfU]++;
                return;
            }
            if (size[ultimateParentOfU] < size[ultimateParentOfV]) {
                parent[ultimateParentOfU] = ultimateParentOfV;
                size[ultimateParentOfV] += size[ultimateParentOfU] + 1;
            } else {
                parent[ultimateParentOfV] = ultimateParentOfU;
                size[ultimateParentOfU] += size[ultimateParentOfV] + 1;
            }
        }
    }

    private int countServers(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final DisjointSet disjointSet = new DisjointSet(m + n + 1);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    disjointSet.unionBySize(i, j + m);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < disjointSet.parent.length; ++i) {
            if (disjointSet.parent[i] == i && disjointSet.size[i] > 1) {
                result += disjointSet.size[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(new CountServersThatCommunicate().countServers(grid));
    }
}
