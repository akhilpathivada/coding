/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * */
package tree;

public class CountGoodNodesInBinaryTree {

    int goodNodes = 0;
    private void preorder(TreeNode root, int maxNodeInPath) {
        if (root == null) {
            return;
        }
        if (root.data >= maxNodeInPath) {
            ++goodNodes;
        }
        preorder(root.left, Math.max(maxNodeInPath, root.data));
        preorder(root.right, Math.max(maxNodeInPath, root.data));
    }

    private int goodNodes(TreeNode root) {
         preorder(root, root.data);
         return goodNodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(new CountGoodNodesInBinaryTree().goodNodes(root));
    }
}
