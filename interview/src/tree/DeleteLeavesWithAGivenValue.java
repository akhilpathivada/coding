/**
 * Date 09/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
package tree;

public class DeleteLeavesWithAGivenValue {

    private TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }
        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }
        return (root.left == root.right && target == root.data) ? null : root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.preOrder(root);
        int target = 2;
        new DeleteLeavesWithAGivenValue().removeLeafNodes(root, target);
        root.preOrder(root);
    }
}
