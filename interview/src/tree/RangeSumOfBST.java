/**
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

public class RangeSumOfBST {
	private int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}
		if (root.data > high) {
			return rangeSumBST(root.left, low, high);
		}
		if (root.data < low) {
			return rangeSumBST(root.right, low, high);
		}
		return root.data + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(15);
		root.right.right = new TreeNode(18);
		int low = 7, high = 15;
		System.out.println(new RangeSumOfBST().rangeSumBST(root, low, high));
	}
}
