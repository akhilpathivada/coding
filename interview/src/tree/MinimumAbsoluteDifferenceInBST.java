/**
 * author: akhilpathivada
 * time: 18/06/24 14:28
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 */
package tree;

public class MinimumAbsoluteDifferenceInBST {

    private TreeNode prev = null;

    private int minDiff = Integer.MAX_VALUE;

    private int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return minDiff;
        }
        getMinimumDifference(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, root.data - prev.data);
        }
        prev = root;
        getMinimumDifference(root.right);
        return minDiff;
    }

    public static void main(String[] args) {

    }
}
