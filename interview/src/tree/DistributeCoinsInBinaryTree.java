/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * */package tree;

public class DistributeCoinsInBinaryTree {

    private int moves = 0;

    private int dfs(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        int coinsFromLeft = dfs(root.left);
        int coinsFromRight = dfs(root.right);
        moves += Math.abs(coinsFromLeft) + Math.abs(coinsFromRight);
        // no. of coins given to parent
        return root.data + coinsFromLeft + coinsFromRight - 1;
    }

    private int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(new DistributeCoinsInBinaryTree().distributeCoins(root));
    }
}
