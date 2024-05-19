/**
 * author: akhilpathivada
 * time: 19/05/24 20:37
 */
package tree;

public class SearchNodeInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.data == val) {
            return root;
        }
        if (val < root.data) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
