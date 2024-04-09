package tree;

import java.util.*;

/**
 * Date 09/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
public class DeleteNodesAndReturnForest {

    private TreeNode delNodesUtil(TreeNode root, Set<Integer> to_delete_set, List<TreeNode> result) {
        // base case
        if (root == null) {
            return null;
        }
        root.left = delNodesUtil(root.left, to_delete_set, result);
        root.right = delNodesUtil(root.right, to_delete_set, result);
        boolean shouldDelete = to_delete_set.contains(root.data);
        if (shouldDelete) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
        }
        return shouldDelete ? null : root;
    }

    private List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> to_delete_set = new HashSet<>();
        for (int node : to_delete) {
            to_delete_set.add(node);
        }
        List<TreeNode> result = new ArrayList<>();
        if (!to_delete_set.contains(root.data)) {
            result.add(root);
        }
        delNodesUtil(root, to_delete_set, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        int[] to_delete = {3, 5};
        System.out.println(new DeleteNodesAndReturnForest().delNodes(root, to_delete));
    }
}
