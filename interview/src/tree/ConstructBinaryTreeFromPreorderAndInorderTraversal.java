/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 *
 */
package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

        private TreeNode buildTreeUtil(int preorderStart, int inorderStart, int inorderEnd, int[] preorder,
                Map<Integer, Integer> nodeToInOrderIndexMap) {
                // base case
                if (preorderStart > preorder.length - 1 || inorderStart > inorderEnd) {
                        return null;
                }
                // create the root
                TreeNode root = new TreeNode(preorder[preorderStart]);
                // search the index of current root in inorder
                int inOrderIndexOfTheRoot = nodeToInOrderIndexMap.get(preorder[preorderStart]);
                // recur to create left and right subtrees
                root.left = buildTreeUtil(preorderStart + 1, inorderStart, inOrderIndexOfTheRoot - 1, preorder,
                        nodeToInOrderIndexMap);
                root.right = buildTreeUtil(preorderStart + inOrderIndexOfTheRoot - inorderStart + 1,
                        inOrderIndexOfTheRoot + 1, inorderEnd, preorder, nodeToInOrderIndexMap);
                return root;
        }

        private TreeNode buildTree(int[] preorder, int[] inorder) {
                // store the indexes of nodes of the inorder
                Map<Integer, Integer> nodeToInOrderIndexMap = new HashMap<>();
                for (int i = 0; i < inorder.length; ++i) {
                        nodeToInOrderIndexMap.put(inorder[i], i);
                }
                return buildTreeUtil(0, 0, inorder.length - 1, preorder, nodeToInOrderIndexMap);
        }

        public static void main(String[] args) {
                int[] preorder = { 3, 9, 20, 15, 7 }, inorder = { 9, 3, 15, 20, 7 };
                TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
                root.preOrder(root);
        }
}
