/**
 * author: akhilpathivada
 * time: 20/05/24 11:50
 *
 * https://leetcode.com/problems/longest-univalue-path/
 *
 */
package tree;

public class LongestUnivaluePath {

    private int result = 0;

    private static final class Pair {

        private int value;

        private int count;

        private Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    private Pair longestUnivaluePathUtil(TreeNode root) {
        if (root == null) {
            return null;
        }
        Pair left = longestUnivaluePathUtil(root.left);
        Pair right = longestUnivaluePathUtil(root.right);
        int longestUVFromLeftSubtree = 0;
        int longestUVFromRightSubtree = 0;
        if (left != null && left.value == root.data) {
            longestUVFromLeftSubtree += left.count + 1;
        }
        if (right != null && right.value == root.data) {
            longestUVFromRightSubtree += right.count + 1;
        }
        result = Math.max(result, longestUVFromLeftSubtree + longestUVFromRightSubtree);
        return new Pair(root.data, Math.max(longestUVFromLeftSubtree, longestUVFromRightSubtree));
    }

    private int longestUnivaluePath(TreeNode root) {
        longestUnivaluePathUtil(root);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
    }
}
