/**
 * author: akhilpathivada
 * time: 22/06/24 08:27
 *
 * https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
 *
 */
package tree.levelorder;

import tree.TreeNode;

import java.util.*;

public class ReverseOddLevelsOfBinaryTree {

    private TreeNode reverseOddLevels(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        boolean isEvenLevel = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (isEvenLevel) {
                Stack<Integer> stack = new Stack<>();
                for (TreeNode node : queue) {
                    stack.push(node.data);
                }
                for (TreeNode node : queue) {
                    node.data = stack.pop();
                }
            }
            isEvenLevel = !isEvenLevel;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
