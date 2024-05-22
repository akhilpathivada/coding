/**
 * author: akhilpathivada
 * time: 22/05/24 09:29
 *
 * https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
 * 
 */
package disjointset;

public class MinimumScoreOfAPathBetweenTwoCities {

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

    private int minScore(int n, int[][] roads) {
        final DisjointSet disjointSet = new DisjointSet(n);
        for (int[] road : roads) {
            disjointSet.unionBySize(road[0], road[1]);
        }
        int result = Integer.MAX_VALUE;
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            if (disjointSet.findUltimateParent(u) == disjointSet.findUltimateParent(1)
                    || disjointSet.findUltimateParent(v) == disjointSet.findUltimateParent(1)) {
                result = Math.min(result, w);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1, 2, 2}, {1, 3, 4}, {3, 4, 7}};
        System.out.println(new MinimumScoreOfAPathBetweenTwoCities().minScore(n, roads));
    }
}
