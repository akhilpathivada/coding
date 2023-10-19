/**
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * */
package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    private void pathSumUtil(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum) {
        // base case
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null && root.data == sum) {
            result.add(new ArrayList<>(path));
        } else {
            pathSumUtil(root.left, result, path, sum - root.data);
            pathSumUtil(root.right, result, path, sum - root.data);
        }
        path.remove(path.size() - 1);
    }

    private List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumUtil(root, result, new ArrayList<>(), targetSum);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        System.out.println(new PathSumII().pathSum(root, targetSum));
    }
}
