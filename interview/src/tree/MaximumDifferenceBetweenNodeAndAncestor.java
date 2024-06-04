/**
 * author: akhilpathivada
 * time: 04/06/24 10:44
 *
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 *
 */
package tree;

public class MaximumDifferenceBetweenNodeAndAncestor {

    private final class Pair {

        private int min;

        private int max;

        private Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private int result = 0;

    // top-down
    private int maxAncestorDiffUtil_topDown(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        min = Math.min(min, root.data);
        max = Math.max(max, root.data);
        return result = Math.max(maxAncestorDiffUtil_topDown(root.left, min, max), maxAncestorDiffUtil_topDown(root.right, min, max));
    }

    // bottom-up
    private Pair maxAncestorDiffUtil_bottomUp(TreeNode root) {
        if (root == null) {
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Pair left = maxAncestorDiffUtil_bottomUp(root.left);
        Pair right = maxAncestorDiffUtil_bottomUp(root.right);
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));
        result = Math.max(result, Math.max(Math.abs(root.data - min), Math.abs(root.data - max)));
        return new Pair(min, max);
    }

    private int maxAncestorDiff(TreeNode root) {
        maxAncestorDiffUtil_topDown(root, root.data, root.data);
        System.out.println(result);
        result = 0;
        maxAncestorDiffUtil_bottomUp(root);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(3);
        System.out.println(new MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(root));
    }
}
