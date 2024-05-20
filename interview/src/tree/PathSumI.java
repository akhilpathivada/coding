/**
 * author: akhilpathivada
 * time: 20/05/24 11:38
 *
 * https://leetcode.com/problems/path-sum/description/
 *
 */
package tree;

public class PathSumI {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || targetSum < 0) {
            return false;
        }
        if (targetSum == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
    }

    public static void main(String[] args) {

    }
}
