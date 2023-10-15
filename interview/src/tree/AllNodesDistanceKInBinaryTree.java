/**
 * Date 26/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AllNodesDistanceKInBinaryTree {

        private List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
                // holds the <child, parent> mapping
                Map<TreeNode, TreeNode> childToParentMap = new HashMap<>();
                childToParentMap.put(root, null);
                // do BFS
                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                // do BFS
                while (!queue.isEmpty()) {
                        int n = queue.size();
                        while (n-- > 0) {
                                TreeNode node = queue.poll();
                                // put the <child, parent> entries
                                if (node.left != null) {
                                        queue.add(node.left);
                                        childToParentMap.put(node.left, node);
                                }
                                if (node.right != null) {
                                        queue.add(node.right);
                                        childToParentMap.put(node.right, node);
                                }
                        }
                }
                // keep track whether the node is visited or not
                // because while we traverse back from a parent, it's child might be already visited :
                // since because here we traverse bi-directionally upwards && downwards
                Map<TreeNode, Boolean> visited = new HashMap<>();
                queue.offer(target);
                // do BFS upwards and downwards
                while (k-- > 0 && !queue.isEmpty()) {
                        int n = queue.size();
                        while (n-- > 0) {
                                TreeNode node = queue.poll();
                                // mark the current node as visited
                                visited.put(node, true);
                                if (node.left != null && !visited.containsKey(node.left)) {
                                        queue.add(node.left);
                                }
                                if (node.right != null && !visited.containsKey(node.right)) {
                                        queue.add(node.right);
                                }
                                if (childToParentMap.get(node) != null && !visited.containsKey(
                                        childToParentMap.get(node))) {
                                        queue.add(childToParentMap.get(node));
                                }
                        }
                }
                List<Integer> result = new ArrayList<>();
                while (!queue.isEmpty()) {
                        result.add(queue.poll().data);
                }
                return result;
        }

        public static void main(String[] args) {
                TreeNode root = new TreeNode(3);
                root.left = new TreeNode(5);
                root.left.left = new TreeNode(6);
                root.left.right = new TreeNode(2);
                root.left.right.left = new TreeNode(7);
                root.left.right.right = new TreeNode(4);
                root.right = new TreeNode(1);
                root.right.left = new TreeNode(0);
                root.right.right = new TreeNode(8);
                TreeNode target = root.left;
                int k = 2;
                System.out.println(new AllNodesDistanceKInBinaryTree().distanceK(root, target, k));
        }
}
