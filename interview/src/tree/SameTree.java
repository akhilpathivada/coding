/**
 * https://leetcode.com/problems/same-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

public class SameTree {

    private static boolean isSameTree(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.data == root2.data) && (isSameTree(root1.left, root2.left)) && (isSameTree(root1.right,
                root2.right));
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(isSameTree(root1, root2));
    }
}
