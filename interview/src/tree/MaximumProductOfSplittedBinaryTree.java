/**
 * author: akhilpathivada
 * time: 07/10/24 21:29
 *
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 *
 */
package tree;

public class MaximumProductOfSplittedBinaryTree {

    private int maxProduct(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        System.out.println("root = " + root.data);
        int leftSum = maxProduct(root.left, sum);
        int rightSum = maxProduct(root.right, sum);
        System.out.println("left sum = " + leftSum);
        System.out.println("right sum = " + rightSum);
        System.out.println("returning = " + Math.max((root.data + leftSum) * rightSum, leftSum * (root.data + rightSum)));
        return Math.max((root.data + leftSum) * rightSum, leftSum * (root.data + rightSum));
    }

    private int maxProduct(TreeNode root) {
        return maxProduct(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        System.out.println(new MaximumProductOfSplittedBinaryTree().maxProduct(root));
    }
}
