/**
 * Date 09/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package tree;

import java.util.Map;

public class MaximumSumBSTInBinaryTree {

    private int maxSumOfBST;

    private static final class Quadruple {

        private final boolean isBST;

        private final int maxFromLeft;

        private final int minFromRight;

        private final int sumOfTree;

        private Quadruple(boolean isBST, int maxFromLeft, int minFromRight, int sumOfTree) {
            this.isBST = isBST;
            this.maxFromLeft = maxFromLeft;
            this.minFromRight = minFromRight;
            this.sumOfTree = sumOfTree;
        }
    }

    private Quadruple maxSumBSTUtil(TreeNode root) {
        // base case
        if (root == null) {
            return new Quadruple(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        Quadruple leftSubTree = maxSumBSTUtil(root.left);
        Quadruple rightSubTree = maxSumBSTUtil(root.right);
        boolean isCurrentTreeBST = leftSubTree.isBST && rightSubTree.isBST
                && leftSubTree.maxFromLeft < root.data && rightSubTree.minFromRight > root.data;
        int sum = root.data + leftSubTree.sumOfTree + rightSubTree.sumOfTree;
        if (isCurrentTreeBST) {
            maxSumOfBST = Math.max(maxSumOfBST, sum);
        }
        return new Quadruple(isCurrentTreeBST, Math.max(root.data, rightSubTree.maxFromLeft),
                Math.min(root.data, leftSubTree.minFromRight), sum);
    }

    private int maxSumBST(TreeNode root) {
        maxSumOfBST = Integer.MIN_VALUE;
        maxSumBSTUtil(root);
        return maxSumOfBST;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
    }
}
