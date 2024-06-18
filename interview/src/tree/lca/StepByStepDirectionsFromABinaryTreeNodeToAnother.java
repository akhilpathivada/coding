/**
 * author: akhilpathivada
 * time: 18/06/24 11:07
 *
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/
 *
 */
package tree.lca;

import tree.TreeNode;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    private TreeNode getLCA(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        TreeNode left = getLCA(root.left, n1, n2);
        TreeNode right = getLCA(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private boolean storePath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.data == target) {
            return true;
        }
        path.append('L');
        if (storePath(root.left, target, path)) {
            return true;
        }
        path.replace(path.length() - 1, path.length(), "R");
        if (storePath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }

    private String getDirections(TreeNode root, int startValue, int destValue) {
        final TreeNode lca = getLCA(root, startValue, destValue);
        StringBuilder path = new StringBuilder();
        storePath(lca, startValue, path);
        // replace all chars of lca_to_start with 'U'
        path = new StringBuilder("U".repeat(path.length()));
        storePath(lca, destValue, path);
        return path.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        int startValue = 3, destValue = 6;
        System.out.println(new StepByStepDirectionsFromABinaryTreeNodeToAnother().getDirections(root, startValue, destValue));
    }
}
