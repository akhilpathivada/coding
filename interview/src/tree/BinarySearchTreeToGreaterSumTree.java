/**
 * author: akhilpathivada
 * time: 12/05/24 20:09
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
 *
 */
package tree;

public class BinarySearchTreeToGreaterSumTree {

    private int sum = 0;

    private TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst(root.right);
        sum += root.data;
        root.data = sum;
        bstToGst(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root = new BinarySearchTreeToGreaterSumTree().bstToGst(root);
        root.preOrder(root);
    }
}
