/**
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * */
package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {

    int count = 0;
    private void pathSumUtil(TreeNode root, int targetSum, int currentSum) {
        // base case
        if (root == null) {
            return;
        }

        if (currentSum == targetSum) {
            ++count;
        }
        currentSum -= root.data;
        pathSumUtil(root.left,  targetSum, currentSum);
        pathSumUtil(root.right,  targetSum, currentSum);
        currentSum += root.data;
    }

    private int pathSum(TreeNode root, int targetSum) {
        pathSumUtil(root,  targetSum, 0);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 8;
        System.out.println(new PathSumIII().pathSum(root, targetSum));
    }
}
