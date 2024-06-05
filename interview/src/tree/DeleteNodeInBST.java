/**
 * author: akhilpathivada
 * time: 18/05/24 17:45
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 */
package tree;

public class DeleteNodeInBST {

    private int getInorderSuccessor(TreeNode root) {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) { // target lies in left subtree
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) { // target lies in right subtree
            root.right = deleteNode(root.right, key);
        } else { // found target
            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = getInorderSuccessor(root.right); // replace root's data with inorder successor's data
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int key = 4;
        root = new DeleteNodeInBST().deleteNode(root, key);
        root.preOrder();
    }
}
