/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 *
 * Time Complexity: O(N * log(N))
 * Space Complexity: O(N)
 * */
package tree;

public class MaximumBinaryTree {

    private int getIndexOfMaxValue(int[] nums, int start, int end) {
        if (start < 0 || start >= nums.length || end < 0 || end >= nums.length || start > end) {
            return -1;
        }
        int indexOfMaxValue = start;
        for (int i = start; i <= end; ++i) {
            if (nums[i] > nums[indexOfMaxValue]) {
                indexOfMaxValue = i;
            }
        }
        return indexOfMaxValue;
    }

    private TreeNode f(int[] nums, int left, int right) {
        int indexOfMaxValue = getIndexOfMaxValue(nums, left, right);
        if (indexOfMaxValue == -1) {
            return null;
        }
        TreeNode root = new TreeNode(nums[indexOfMaxValue]);
        root.left = f(nums, left, indexOfMaxValue - 1);
        root.right = f(nums, indexOfMaxValue + 1, right);
        return root;
    }

    private TreeNode constructMaximumBinaryTree(int[] nums) {
        return f(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        TreeNode root = new MaximumBinaryTree().constructMaximumBinaryTree(nums);
        root.preOrder(root);
    }
}
