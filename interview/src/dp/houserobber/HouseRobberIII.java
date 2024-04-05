/**
 * Date 09/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/house-robber-iii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package dp.houserobber;

import tree.TreeNode;

public class HouseRobberIII {

    private int[] dfs(TreeNode root) {
        // base case
        if (root == null) {
            return new int[2];
        }
        int[] dp_left = dfs(root.left);
        int[] dp_right = dfs(root.right);
        int[] result = new int[2];
        // if we dont want to include root
        result[0] = Math.max(dp_left[0], dp_left[1]) + Math.max(dp_right[0], dp_right[1]);
        // if we want to include root
        result[1] = root.data + dp_left[0] + dp_right[0];
        return result;
    }

    private int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(new HouseRobberIII().rob(root));
    }
}
