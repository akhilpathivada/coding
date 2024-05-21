/**
 * author: akhilpathivada
 * time: 21/05/24 14:08
 *
 * https://leetcode.com/problems/complete-binary-tree-inserter/
 *
 */
package design;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {

    private final Queue<TreeNode> queue;

    private TreeNode root;

    public CompleteBinaryTreeInserter(TreeNode root) {
        this.queue = new LinkedList<>();
        this.root = root;
        queue.add(root);
        // iterate till we encounter first non-full node
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        if (queue.peek().left != null) {
            queue.offer(queue.peek().left);
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode parent = queue.peek();
        if (parent.left == null) {
            parent.left = node;
        } else if (parent.right == null) {
            parent.right = node;
            queue.poll();
        }
        queue.add(node);
        return parent.data;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        CompleteBinaryTreeInserter cBTInserter = new CompleteBinaryTreeInserter(new TreeNode(1));
        System.out.println(cBTInserter.insert(3));  // return 1
        System.out.println(cBTInserter.insert(4));  // return 1
        cBTInserter.get_root(); // return [1, 3, 4]
    }
}
