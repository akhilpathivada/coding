/**
 *
 * Time Complexity: O(Q * 4α) ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.
 * Space Complexity: O(Q) + O(N * M) + O(N * M), where Q = no. of queries, N = total no. of rows, M = total no. of columns.
 *
 *  */
package disjointset;

public class DisjointSet {

    int[] size; // stores size
    int[] parent; // stores parent of each node

    public DisjointSet(int n) {
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
    public int findUltimateParent(int node) {
        // this the ultimate parent (root)
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }

    public void unionBySize(int u, int v) {
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

    public static void main(String[] args) {
        int n = 7;
        DisjointSet disjointSet = new DisjointSet(n);
        disjointSet.unionBySize(1, 2);
        disjointSet.unionBySize(2, 3);
        disjointSet.unionBySize(4, 5);
        disjointSet.unionBySize(6, 7);
        disjointSet.unionBySize(5, 6);
        System.out.println(disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7));
        disjointSet.unionBySize(3, 7);
        System.out.println(disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7));
    }
}
