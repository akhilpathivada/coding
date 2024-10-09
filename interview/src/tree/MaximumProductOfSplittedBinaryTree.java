/**
 * author: akhilpathivada
 * time: 07/10/24 21:29
 *
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 *
 */
package tree;

public class MaximumProductOfSplittedBinaryTree {

    private long totalTreeSum = 0;

    private long result = 0;

    private long maxProductUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long leftSubtreeSum = maxProductUtil(root.left);
        long rightSubtreeSum = maxProductUtil(root.right);
        long upperSubtreeSum = totalTreeSum - leftSubtreeSum - rightSubtreeSum - root.data;
        result = Math.max(result,
                Math.max(upperSubtreeSum * (root.data + leftSubtreeSum + rightSubtreeSum),
                        Math.max(leftSubtreeSum * (upperSubtreeSum + root.data + rightSubtreeSum),
                                rightSubtreeSum * (upperSubtreeSum + root.data + leftSubtreeSum))));
        return root.data + leftSubtreeSum + rightSubtreeSum;
    }

    private long calculateTotalTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (long) root.data + calculateTotalTreeSum(root.left) + calculateTotalTreeSum(root.right);
    }

    // logic: https://www.youtube.com/watch?v=8WL9lUp8EvE
    private int maxProduct(TreeNode root) {
        totalTreeSum = calculateTotalTreeSum(root);
        maxProductUtil(root);
        return (int) result % ((int) 1e9 + 7);
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
