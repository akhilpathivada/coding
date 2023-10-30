/**
 * https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/
 *
 * Time Complexity: O(constant) to check two elements belongs to same set
 * */
package advanced.disjointset;

public class DisjointSet {

    int[] rank; // stores rank of a node
    int[] parent; // stores parent of each node

    public DisjointSet(int n) {
        // create with n + 1 size: so that it would be useful for 0-indexed and 1-indexed as well
        rank = new int[n + 1];
        parent = new int[n + 1];
        // initially every node itself is a disjoint set
        // so parent of a node is itself
        for (int i = 0; i <= n; ++i) {
            parent[i] = i;
        }
    }

    // to find the ultimate parent of a node
    // and do "path compression"
    public int findUltimateParent(int node) {
        // this the ultimate parent (root)
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }

    public void unionByRank(int u, int v) {
        int ultimateParentOfU = findUltimateParent(u);
        int ultimateParentOfV = findUltimateParent(v);
        // if both are already in same set
        if (ultimateParentOfU == ultimateParentOfV) {
            return;
        }
        if (rank[ultimateParentOfU] < rank[ultimateParentOfV]) {
            parent[u] = ultimateParentOfV;
        } else if (rank[ultimateParentOfV] < rank[ultimateParentOfU]) {
            parent[v] = ultimateParentOfU;
        } else {
            parent[ultimateParentOfV] = ultimateParentOfU;
            rank[ultimateParentOfU]++;
        }
    }

    public static void main(String[] args) {
        int n = 7;
        DisjointSet disjointSet = new DisjointSet(n);
        disjointSet.unionByRank(1, 2);
        disjointSet.unionByRank(2, 3);
        disjointSet.unionByRank(4, 5);
        disjointSet.unionByRank(6, 7);
        disjointSet.unionByRank(5, 6);
        System.out.println(disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7));
        disjointSet.unionByRank(3, 7);
        System.out.println(disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7));
    }
}
