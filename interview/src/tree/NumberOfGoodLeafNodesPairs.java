/**
 *
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/description/
 *
 * */
package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfGoodLeafNodesPairs {

    private void storeLeafPaths(TreeNode root, List<TreeNode> leaves, List<TreeNode> path,
                                Map<TreeNode, List<TreeNode>> leavesPathMap) {
        if (root == null) {
            return;
        }
        final List<TreeNode> temp = new ArrayList<>(path);
        temp.add(root);
        if (root.left == null && root.right == null) {
            leaves.add(root);
            leavesPathMap.put(root, temp);
            return;
        }
        storeLeafPaths(root.left, leaves, temp, leavesPathMap);
        storeLeafPaths(root.right, leaves, temp, leavesPathMap);
    }

    private int countPairs(TreeNode root, int distance) {
        final List<TreeNode> leaves = new ArrayList<>();
        final Map<TreeNode, List<TreeNode>> leavesPathMap = new HashMap<>();
        int pairs = 0;
        storeLeafPaths(root, leaves, new ArrayList<>(), leavesPathMap);
        for (int i = 0; i < leaves.size(); ++i) {
            for (int j = i + 1; j < leaves.size(); ++j) {
                List<TreeNode> list1 = leavesPathMap.get(leaves.get(i));
                List<TreeNode> list2 = leavesPathMap.get(leaves.get(j));
                for (int k = 0; k < Math.min(list1.size(), list2.size()); ++k) {
                    if (list1.get(k) != list2.get(k)) {
                        int dist = list1.size() - k + list2.size() - k;
                        if (dist <= distance) {
                            ++pairs;
                        }
                        break;
                    }
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        int distance = 3;
        System.out.println(new NumberOfGoodLeafNodesPairs().countPairs(root, distance));
    }
}
