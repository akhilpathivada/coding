/**
 * author: akhilpathivada
 * time: 05/06/24 20:07
 *
 * https://leetcode.com/problems/kth-ancestor-of-a-tree-node/description/
 *
 */
package tree;

public class KthAncestorOfATreeNode {

    private final int[] parent;

    public KthAncestorOfATreeNode(int n, int[] parent) {
        this.parent = parent;
    }

    public int getKthAncestor(int node, int k) {
        while (node != -1 && parent[node] != node && k-- > 0) {
            node = parent[node];
        }
        return k > 0 ? -1 : node;
    }

    public static void main(String[] args) {
        KthAncestorOfATreeNode treeAncestor = new KthAncestorOfATreeNode(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1)); // returns 1 which is the parent of 3
        System.out.println(treeAncestor.getKthAncestor(5, 2)); // returns 0 which is the grandparent of 5
        System.out.println(treeAncestor.getKthAncestor(6, 3)); // returns -1 because there is no such ancestor
    }
}
