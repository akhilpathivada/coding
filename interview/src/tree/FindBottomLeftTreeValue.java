/**
 * author: akhilpathivada
 * time: 04/06/24 09:25
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 */
package tree;

public class FindBottomLeftTreeValue {

    private int bottom = 0;

    private int bottomLeftValue = 0;

    private void findBottomLeftValueUtil(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > bottom) {
            bottom = depth;
            bottomLeftValue = root.data;
        }
        findBottomLeftValueUtil(root.left, 1 + depth);
        findBottomLeftValueUtil(root.right, 1 + depth);
    }

    private int findBottomLeftValue(TreeNode root) {
        findBottomLeftValueUtil(root, 1);
        return bottomLeftValue;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue(root));
    }
}
