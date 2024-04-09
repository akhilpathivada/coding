/**
 * Date 09/04/24
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package tree;

import java.util.*;

public class FindDuplicateSubtrees {

    private String serialize(TreeNode root, Map<String, List<TreeNode>> map) {
        // base case
        if (root == null) {
            return "";
        }
        String serializedTree = "(" + serialize(root.left, map) + root.data + serialize(root.right, map) + ")";
        map.computeIfAbsent(serializedTree, list -> new ArrayList<>()).add(root);
        return serializedTree;
    }

    private List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, List<TreeNode>> map = new HashMap<>();
        serialize(root, map);
        for (Map.Entry<String, List<TreeNode>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue().get(0));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(root));
    }
}
