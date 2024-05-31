/**
 * author: akhilpathivada
 * time: 31/05/24 11:27
 *
 * https://leetcode.com/problems/binary-tree-paths/
 *
 */
package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private void binaryTreePathsUtil(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(path + root.data);
            return;
        }
        binaryTreePathsUtil(root.left, path + root.data + "->", result);
        binaryTreePathsUtil(root.right, path + root.data + "->", result);
    }

    private List<String> binaryTreePaths(TreeNode root) {
        final List<String> result = new ArrayList<>();
        binaryTreePathsUtil(root, "", result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        System.out.println(new BinaryTreePaths().binaryTreePaths(root));
    }
}
