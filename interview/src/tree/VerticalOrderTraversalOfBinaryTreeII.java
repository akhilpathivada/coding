/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class VerticalOrderTraversalOfBinaryTreeII {

        private void verticalTraversal(TreeNode root, int hd, TreeMap<Integer, List<Integer>> map) {
                // base case
                if (root == null) {
                        return;
                }
                List<Integer> nodes = map.get(hd);
                // if there is no entry for this hd
                if (nodes == null) {
                        nodes = new ArrayList<>();
                }
                // add root data into list
                nodes.add(root.data);
                // insert back the <k, v>
                map.put(hd, nodes);
                // Recur for left and right subtrees
                verticalTraversal(root.left, hd - 1, map);
                verticalTraversal(root.right, hd + 1, map);
        }

        private List<List<Integer>> verticalTraversal(TreeNode root) {
                // stores horizontal distance and nodes having that distance
                TreeMap<Integer, List<Integer>> map = new TreeMap<>();
                int hd = 0; // horizontal distance
                verticalTraversal(root, hd, map);
                List<List<Integer>> result = new ArrayList<>();
                // moving the values of TreeMap into result
                int index = 0;
                for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                        result.add(new ArrayList<>(entry.getValue()));
                        ++index;
                }
                return result;
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(6);
                root.right.right = new TreeNode(7);
                root.right.left.right = new TreeNode(8);
                root.right.right.right = new TreeNode(9);
                System.out.println(new VerticalOrderTraversalOfBinaryTreeII().verticalTraversal(root));
        }
}