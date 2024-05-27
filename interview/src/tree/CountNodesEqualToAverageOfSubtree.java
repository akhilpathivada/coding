/**
 * author: akhilpathivada
 * time: 27/05/24 17:33
 *
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/
 *
 */
package tree;

public class CountNodesEqualToAverageOfSubtree {

    private final class Pair {

        private final int sum; // sum of all nodes in this subtree

        private final int count; // count of nodes in this subtree

        private Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    private int result = 0;

    private Pair averageOfSubtreeUtil(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair leftSubtree = averageOfSubtreeUtil(root.left);
        Pair rightSubtree = averageOfSubtreeUtil(root.right);
        Pair current = new Pair(root.data + leftSubtree.sum + rightSubtree.sum, 1 + leftSubtree.count + rightSubtree.count);
        if (current.sum / current.count == root.data) {
            ++result;
        }
        return current;
    }

    private int averageOfSubtree(TreeNode root) {
        averageOfSubtreeUtil(root);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(new CountNodesEqualToAverageOfSubtree().averageOfSubtree(root));
    }
}
