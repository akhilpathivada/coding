/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST extends TreeNode {
        
        private TreeNode convertSortedArrayToBST(List<TreeNode> sortedArray, int start, int end) {
                // base case
                if(start > end) {
                        return null;
                }
                // get mid element and make as root
                int mid = (start + end) / 2;
                TreeNode root = sortedArray.get(mid);
                // recur for left and right subtrees
                root.left = convertSortedArrayToBST(sortedArray, start, mid - 1);
                root.right = convertSortedArrayToBST(sortedArray, mid + 1, end);
                return root;
        }
        
        private void getSortedArray(TreeNode root, List<TreeNode> sortedArray) {
                // base case
                if(root == null) {
                        return;
                }
                getSortedArray(root.left, sortedArray);
                // insert element into list
                sortedArray.add(root);
                getSortedArray(root.right, sortedArray);
        }
        
        private TreeNode balanceBinaryTreeToBST(TreeNode root) {
                List<TreeNode> sortedArray = new ArrayList<TreeNode>();
                // get the BST as a sorted array
                getSortedArray(root, sortedArray);
                // convert sorted array to BST
                return convertSortedArrayToBST(sortedArray, 0 , sortedArray.size() - 1);
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(10);
                root.left = new TreeNode(8);
                root.left.left = new TreeNode(7);
                root.left.left.left = new TreeNode(6);
                root.left.left.left.left = new TreeNode(5);
                BalanceBST obj = new BalanceBST();
                root = obj.balanceBinaryTreeToBST(root);
                obj.preOrder(root);
        }
}
