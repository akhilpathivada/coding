/**
 * @author akhilpathivada
 * <p>
 * date : 01/04/24
 * time: 19:17
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 *
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
package tree;

public class SumRootToLeafNumbers {

    private int sumNumbers(TreeNode root, int sum) {
        // base case
        if (root == null) {
            return 0;
        }
        int currentSumSoFar = sum * 10 + root.data;
        // leaf node
        if (root.left == null && root.right == null) {
            return currentSumSoFar;
        }
        return sumNumbers(root.left, currentSumSoFar) + sumNumbers(root.right, currentSumSoFar);
    }

    private int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }
}
