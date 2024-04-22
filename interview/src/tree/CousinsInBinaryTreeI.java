/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;


import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTreeI {
        
        private boolean checkCousins(TreeNode root, int x, int y) {
                // base case
                if (root == null) {
                        return false;
                }
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                while (!queue.isEmpty()) {
                        // count nodes in current level
                        int n = queue.size();
                        boolean xFound = false;
                        boolean yFound = false;
                        // iterate over all nodes in current level
                        while (n-- > 0) {
                                TreeNode curr = queue.poll();
                                // if x, y is found
                                if (curr.data == x) {
                                        xFound = true;
                                }
                                if (curr.data == y) {
                                        yFound = true;
                                }
                                // return false if they are siblings
                                if (curr.left != null && curr.right != null) {
                                        if ((curr.left.data == x && curr.right.data == y) 
                                                || (curr.left.data == y && curr.right.data == x)) {
                                                return false;
                                        }
                                }
                                if (curr.left != null) {
                                        queue.offer(curr.left);
                                }
                                if (curr.right != null) {
                                        queue.offer(curr.right);
                                }
                        }
                        // both x, y found at same level with different parents
                        if (xFound && yFound) {
                                return true;
                        }
                }
                return false;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.right.left = new TreeNode(5);
                int x = 4, y = 5;
                System.out.println("Height of Binary Tree = " + new CousinsInBinaryTreeI().checkCousins(root, x, y));
        }
}
