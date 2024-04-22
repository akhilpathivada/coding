package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 21/04/24
 * Time 14:28
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
 */
public class MaximumLevelSumOfABinaryTree {

    private int maxLevelSum(final TreeNode root) {
        int currentLevel = 0;
        int maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ++currentLevel;
            int nodesInTheLevel = queue.size();
            int sumOfTheLevel = 0;
            while (nodesInTheLevel-- > 0) {
                TreeNode current = queue.poll();
                sumOfTheLevel += current.data;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (sumOfTheLevel > maxSum) {
                maxSum = sumOfTheLevel;
                maxLevel = currentLevel;
            }
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        System.out.println(new MaximumLevelSumOfABinaryTree().maxLevelSum(root));
    }
}
