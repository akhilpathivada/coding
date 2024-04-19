/**
 *  Print the right view of a Binary Tree
 *  Time Complexity : O(N)
 *  Space Complexity : O(H) -> Height of Tree
 * */
package tree.view;

import tree.TreeNode;

public class RightViewOfBinaryTreeI {
        
        private static int MAX_LEVEL = 0;

        private void printRightView(TreeNode root, int level) {
                // base case
                if (root == null) {
                        return;
                }
                // if this is the first node of its level
                if (level > MAX_LEVEL) {
                        System.out.print(root.data + ", ");
                        MAX_LEVEL = level;
                }
                // recur for right and left subtrees
                printRightView(root.right, level + 1);
                printRightView(root.left, level + 1);
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(10);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(7);
                root.left.right = new TreeNode(8);
                root.right.right = new TreeNode(15);
                root.right.left = new TreeNode(12);
                root.right.right.left = new TreeNode(14);
                int level = 1;
                new RightViewOfBinaryTreeI().printRightView(root, 1);
        }
}
