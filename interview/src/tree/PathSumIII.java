/**
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * */
package tree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    int count = 0;
    private void pathSumUtil(TreeNode root, Map<Integer, Integer> prefixSumMap, int targetSum, int currentSum) {
        // base case
        if (root == null) {
            return;
        }
        currentSum += root.data;
        if (currentSum == targetSum) {
            ++count;
        }
        count += prefixSumMap.getOrDefault(currentSum - targetSum, 0);
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        pathSumUtil(root.left, prefixSumMap, targetSum, currentSum);
        pathSumUtil(root.right, prefixSumMap, targetSum, currentSum);
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);
    }

    private int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        pathSumUtil(root, prefixSumMap, targetSum, 0);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 8;
        System.out.println(new PathSumIII().pathSum(root, targetSum));
    }
}
