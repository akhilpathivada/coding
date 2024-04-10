/**
 * Date 10/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/similar-string-groups/description/
 *
 */
package disjointset;

public class SimilarStringGroups {

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

    private boolean areSimilar(String a, String b) {
        int numberOfDifferentChars = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i) && ++numberOfDifferentChars == 3) {
                return false;
            }
        }
        return true;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DisjointSet disjointSet = new DisjointSet(n);
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (areSimilar(strs[i], strs[j])) {
                    disjointSet.unionBySize(i, j);
                }
            }
        }
        int countOfConnectedComponents = 0;
        for (int i = 0; i < n; ++i) {
            if (disjointSet.parent[i] == i) {
                ++countOfConnectedComponents;
            }
        }
        return countOfConnectedComponents;
    }

    public static void main(String[] args) {
        String[] strs = {"tars","rats","arts","star"};
        System.out.println(new SimilarStringGroups().numSimilarGroups(strs));
    }
}
