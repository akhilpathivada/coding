/**
 * @author akhilpathivada
 * <p>
 * date : 01/04/24
 * time: 08:13
 *
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
 * https://www.naukri.com/code360/problems/time-to-burn-tree_630563
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TimeToBurnBinaryTree {

    private int findTimeToBurnTree(Map<TreeNode, TreeNode> childToParentMap, TreeNode start) {
        int timeToBurn = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean isAnyNodeBurnt = false;
            while (n-- > 0) {
                TreeNode node = queue.poll();
                // burn the left child
                if (node.left != null && !visited.contains(node.left)) {
                    isAnyNodeBurnt = true;
                    queue.add(node.left);
                    visited.add(node.left);
                }
                // burn the right child
                if (node.right != null && !visited.contains(node.right)) {
                    isAnyNodeBurnt = true;
                    queue.add(node.right);
                    visited.add(node.right);
                }
                // burn the parent
                if (childToParentMap.containsKey(node)) {
                    TreeNode parent = childToParentMap.get(node);
                    if (parent != null && !visited.contains(parent)) {
                        isAnyNodeBurnt = true;
                        queue.add(parent);
                        visited.add(parent);
                    }
                }
            }
            if (isAnyNodeBurnt) {
                ++timeToBurn;
            }
        }
        return timeToBurn;
    }

    private Map<TreeNode, TreeNode> mapChildToParentNode(TreeNode root) {
        Map<TreeNode, TreeNode> childToParentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        childToParentMap.put(root, null);
        queue.add(root);
        // do level order traversal
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                childToParentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                childToParentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
        return childToParentMap;
    }

    private TreeNode findStartNode(Map<TreeNode, TreeNode> childToParentMap, int target) {
        // return the node pointer of the start
        for (Map.Entry<TreeNode, TreeNode> entry : childToParentMap.entrySet()) {
            if (entry.getKey().data == target) {
                return entry.getKey();
            }
        }
        return null;
    }

    private int amountOfTime(TreeNode root, int start) {
        // store the parent pointers
        Map<TreeNode, TreeNode> childToParentMap = mapChildToParentNode(root);
        return findTimeToBurnTree(childToParentMap, findStartNode(childToParentMap, start));
    }

    public static void main(String[] args) {
//        input - 1
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.left.right.left = new TreeNode(9);
//        root.left.right.right = new TreeNode(2);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(6);

//        input - 2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        int start = 1;
        System.out.println(new TimeToBurnBinaryTree().amountOfTime(root, start));
    }
}
