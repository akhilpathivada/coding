/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 */
package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

        private TreeNode buildTreeUtil(int[] postorder, Map<Integer, Integer> nodeToInOrderIndexMap, int inorderStart,
                int inOrderEnd, int postorderStart, int postOrderEnd) {
                // base case
                if (postorderStart > postOrderEnd || inorderStart > inOrderEnd) {
                        return null;
                }
                // root is at last index of postorder
                TreeNode root = new TreeNode(postorder[postOrderEnd]);
                int inOrderIndexOfRoot = nodeToInOrderIndexMap.get(postorder[postOrderEnd]);
                int numberOfNodesToTheLeftOfRoot = inOrderIndexOfRoot - inorderStart;
                root.left = buildTreeUtil(postorder, nodeToInOrderIndexMap, inorderStart, inOrderIndexOfRoot - 1,
                        postorderStart, postorderStart + numberOfNodesToTheLeftOfRoot - 1);
                root.right = buildTreeUtil(postorder, nodeToInOrderIndexMap, inOrderIndexOfRoot + 1, inOrderEnd,
                        postorderStart + numberOfNodesToTheLeftOfRoot, postOrderEnd - 1);
                return root;
        }

        private TreeNode buildTree(int[] inorder, int[] postorder) {
                // base case
                if (inorder == null || postorder == null || inorder.length != postorder.length) {
                        return null;
                }
                // store the indexes of nodes of the inorder
                Map<Integer, Integer> nodeToInOrderIndexMap = new HashMap<>();
                for (int i = 0; i < inorder.length; ++i) {
                        nodeToInOrderIndexMap.put(inorder[i], i);
                }
                return buildTreeUtil(postorder, nodeToInOrderIndexMap, 0, inorder.length - 1, 0, postorder.length - 1);
        }

        public static void main(String[] args) {
                int[] inorder = { 9, 3, 15, 20, 7 }, postorder = { 9, 15, 7, 20, 3 };
                TreeNode root = new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(inorder, postorder);
                root.preOrder(root);
        }

}
