/**
 * author: akhilpathivada
 * time: 18/05/24 20:28
 *
 * https://leetcode.com/problems/add-one-row-to-tree/
 *
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    private TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && --depth > 1) {
            int n = queue.size();
            while (n-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode oldLeftChild = node.left;
            TreeNode newLeftChild = new TreeNode(val);
            node.left = newLeftChild;
            newLeftChild.left = oldLeftChild;
            TreeNode oldRightChild = node.right;
            TreeNode newRightChild = new TreeNode(val);
            node.right = newRightChild;
            newRightChild.right = oldRightChild;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        int val = 1;
        int depth = 2;
        root = new AddOneRowToTree().addOneRow(root, val, depth);
        root.preOrder();
    }
}
