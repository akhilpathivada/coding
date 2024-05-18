/**
 * author: akhilpathivada
 * time: 18/05/24 17:45
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 */
package tree;

public class DeleteNodeInBST {

    private TreeNode parent = null;

    private TreeNode getInorderSuccessor(TreeNode root) {
        TreeNode current = root;
        TreeNode parentOfTheInorderSuccessor = root;
        while (current != null) {
            parentOfTheInorderSuccessor = root;
            current = current.left;
        }
        parentOfTheInorderSuccessor.left = current.right;
        return current;
    }

    private TreeNode getInorderPredecessor(TreeNode root) {
        TreeNode current = root;
        TreeNode parentOfTheInorderSuccessor = root;
        while (current != null) {
            parentOfTheInorderSuccessor = root;
            current = current.left;
        }
        parentOfTheInorderSuccessor.left = current.right;
        return current;
    }



    private TreeNode getTargetNode(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        parent = root;
        if (key < root.data) {
            return getTargetNode(root.left, key);
        }
        return getTargetNode(root.right, key);
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        TreeNode target = getTargetNode(root, key);
        System.out.println(target.data);
        System.out.println(parent.data);
        if (target == null) {
            return root;
        }
        if (target.left == null && target.right == null) {
            if (parent.left == target) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (target.left == null) {
            TreeNode inorderSuccessor = getInorderSuccessor(target.right);
            if (parent.left == target) {
                parent.left = inorderSuccessor;
            } else {
                parent.right = inorderSuccessor;
            }
        } else if (target.right == null) {
            TreeNode inorderPredecessor = getInorderPredecessor(target);
            if (parent.left == target) {
                parent.left = inorderPredecessor;
            } else {
                parent.right = inorderPredecessor;
            }
        } else {
            TreeNode inorderSuccessor = getInorderSuccessor(target);
            if (parent.left == target) {
                parent.left = inorderSuccessor;
            } else {
                parent.right = inorderSuccessor;
            }
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
