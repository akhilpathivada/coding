package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date 28/04/24
 * Time 19:38
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/cousins-in-binary-tree-ii/description/
 *
 */
public class CousinsInBinaryTreeII {

    private TreeNode replaceValueInTree(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.data = 0;
        while (!queue.isEmpty()) {
            int sizeOfTheLevel = queue.size();
            int sumOfTheNextLevel = 0;
            while (sizeOfTheLevel-- > 0) {
                TreeNode node = queue.poll();
                sumOfTheNextLevel += (node.left != null ? node.left.data : 0)
                        + (node.right != null ? node.right.data : 0);
                queue.add(node);
            }
            sizeOfTheLevel = queue.size();
            while (sizeOfTheLevel-- > 0) {
                TreeNode node = queue.poll();
                int sumOfTheCousins = (node.left != null ? node.left.data : 0)
                        + (node.right != null ? node.right.data : 0);
                if (node.left != null) {
                    node.left.data = sumOfTheNextLevel - sumOfTheCousins;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.data = sumOfTheNextLevel - sumOfTheCousins;
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        new CousinsInBinaryTreeII().replaceValueInTree(root);
        root.preOrder(root);
    }
}
