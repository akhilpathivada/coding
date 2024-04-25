package tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Date 25/04/24
 * Time 16:48
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
 */
public class KthLargestSumInABinaryTree {

    private long kthLargestLevelSum(TreeNode root, int k) {
        final Queue<TreeNode> queue = new LinkedList<>();
        final PriorityQueue<Long> minHeap = new PriorityQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodesInTheLevel = queue.size();
            long sumOfTheLevel = 0;
            while (nodesInTheLevel-- > 0) {
                TreeNode node = queue.poll();
                sumOfTheLevel += node.data;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            minHeap.add(sumOfTheLevel);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.size() < k ? -1 : minHeap.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(4);
        root.left.right = new TreeNode(1);
        root.left.left.right = new TreeNode(6);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        int k = 2;
        System.out.println(new KthLargestSumInABinaryTree().kthLargestLevelSum(root, k));
    }
}
