/**
 * author: akhilpathivada
 * time: 29/09/24 15:22
 *
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 *
 */
package tree;

public class TrimABinarySearchTree {

    private TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.data < low) {
            return trimBST(root.right, low, high);
        }
        if (root.data > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        int low = 1;
        int high = 2;
        root = new TrimABinarySearchTree().trimBST(root, low, high);
        root.preOrder();
    }
}
