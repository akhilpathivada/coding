/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

public class SumOfLeftLeaves {
	private int sumOfLeftLeaves(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		int sum = 0;
		if (root.left != null) {
			// if left child is a leaf
			if (root.left.left == null && root.left.right == null) {
				sum += root.left.data;
			} else { // if not
				sum += sumOfLeftLeaves(root.left);
			}
		}
		// recur and find left leaf in right subtree
		sum += sumOfLeftLeaves(root.right);
		return sum;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));
	}
}
