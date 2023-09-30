/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModeInBinarySearchTree {

    private int maxFrequency = 0;
    private List<Integer> result = new ArrayList<>();
    private int predecessor = Integer.MIN_VALUE;

    public void findModeUtil(TreeNode root, int currentNodeFrequency) {
        // base case
        if (root == null) {
            return;
        }
        // do inorder traversal
        findModeUtil(root.left, currentNodeFrequency);
        if (predecessor == root.data) {
            ++currentNodeFrequency;
        } else {
            currentNodeFrequency = 1;
        }
        // Current node value has higher frequency than any previous visited
        if (currentNodeFrequency > maxFrequency) {
            result.clear();
            maxFrequency = currentNodeFrequency;
            if (!result.contains(root.data)) {
                result.add(root.data);
            }
        } else if (currentNodeFrequency == maxFrequency) { // Current node value has a frequency equal to
            // the highest of previous visited
            result.add(root.data);
        }
        predecessor = root.data;
        findModeUtil(root.right, currentNodeFrequency);
    }

    private int[] findMode(TreeNode root) {
        findModeUtil(root, 0);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(new ModeInBinarySearchTree().findMode(root)));
    }
}
