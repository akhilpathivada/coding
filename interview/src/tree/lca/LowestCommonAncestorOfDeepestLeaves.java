/**
 * author: akhilpathivada
 * time: 14/05/24 07:58
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
 *
 */
package tree.lca;

import tree.TreeNode;

public class LowestCommonAncestorOfDeepestLeaves {

    private static final class Pair {

        private final TreeNode node;

        private final int depth;

        private Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    private Pair lcaDeepestLeaves(TreeNode root, int depth) {
        if (root == null) {
            return new Pair(null, depth);
        }
        Pair left = lcaDeepestLeaves(root.left, depth + 1);
        Pair right = lcaDeepestLeaves(root.right, depth + 1);
        if (left.depth == right.depth) {
            return new Pair(root, left.depth);
        }
        return left.depth > right.depth ? left : right;
    }

    private TreeNode lcaDeepestLeaves(TreeNode root) {
        return lcaDeepestLeaves(root, 0).node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(new LowestCommonAncestorOfDeepestLeaves().lcaDeepestLeaves(root));
    }
}
