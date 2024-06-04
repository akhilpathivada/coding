/**
 * author: akhilpathivada
 * time: 04/06/24 10:28
 *
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 *
 */
package tree;

public class DeepestLeavesSum {

    private int maxDepth = 0;

    private int sum = 0;

    private void deepestLeavesSum(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            sum = 0;
        }
        if (depth == maxDepth) {
            sum += root.data;
        }
        deepestLeavesSum(root.left, 1 + depth);
        deepestLeavesSum(root.right, 1 + depth);
    }

    private int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 1);
        return sum;
    }

    public static void main(String[] args) {

    }
}
