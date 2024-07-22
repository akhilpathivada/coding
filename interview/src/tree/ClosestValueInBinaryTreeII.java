/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package tree;

public class ClosestValueInBinaryTreeII {
        
        private static int findClosestValue(TreeNode root, double target) {
                double minDiff = Double.MAX_VALUE;
                int closestValue = -1;
                while (root != null) {
                        double currentDiff = Math.abs(target - root.data);
                        if (currentDiff < minDiff) { // current difference less than min difference so far
                                minDiff = currentDiff;
                                closestValue = root.data;
                        }
                        if (target < root.data) { // check in left subtree
                                root = root.left;
                        } else if (target > root.data) { // check in right subtree
                                root = root.right;
                        } else { // if node equals to target
                                break;
                        }
                }
                return closestValue;
        }
        
        public static void main(String[] args) {
                TreeNode node = new TreeNode(9);
                node.left = new TreeNode(4);
                node.right = new TreeNode(17);
                node.left.left = new TreeNode(3);
                node.left.right = new TreeNode(6);
                node.left.right.left = new TreeNode(5);
                node.left.right.right = new TreeNode(7);
                node.right.right = new TreeNode(22);
                node.right.right.left = new TreeNode(20);
                System.out.println("Closest value of is = " + findClosestValue(node, 18.99));
        }
}
