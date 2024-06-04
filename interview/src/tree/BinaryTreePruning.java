/**
 * author: akhilpathivada
 * time: 04/06/24 09:02
 *
 * https://leetcode.com/problems/binary-tree-pruning/description/
 *
 */
package tree;

public class BinaryTreePruning {

    private TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.data == 0) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
